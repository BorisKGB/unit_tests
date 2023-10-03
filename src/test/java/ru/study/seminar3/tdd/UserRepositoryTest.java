package ru.study.seminar3.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserRepositoryTest {

    @Test
    void logOutNonAdmins() {
        UserRepository userRepository = new UserRepository();
        User admin1 = new User("a", "123", true);
        User admin2 = new User("b", "122", true);
        admin2.isAuthenticate = true;
        User user1 = new User("c", "121", false);
        User user2 = new User("d", "120", false);
        user2.isAuthenticate = true;
        userRepository.data.add(admin1);
        userRepository.data.add(admin2);
        userRepository.data.add(user1);
        userRepository.data.add(user2);
        userRepository.logOutNonAdmins();
        assertThat(userRepository.data)
                .filteredOn(user -> user.isAuthenticate)
                .filteredOn(user -> user.isAdmin).containsExactly(admin2);
        assertThat(userRepository.data)
                .filteredOn(user -> user.isAuthenticate && !user.isAdmin)
                .isEmpty();
    }
}