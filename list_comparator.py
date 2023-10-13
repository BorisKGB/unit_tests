"""
Задание 1
"""


class ListComparator:
    """
    Создайте программу на Python или Java,
    которая принимает два списка чисел и выполняет следующие действия:
    a. Рассчитывает среднее значение каждого списка.
    b. Сравнивает эти средние значения и выводит соответствующее сообщение:
    - ""Первый список имеет большее среднее значение"", если среднее значение первого списка больше.
    - ""Второй список имеет большее среднее значение"", если среднее значение второго списка больше.
    - ""Средние значения равны"", если средние значения списков равны.
    """
    @staticmethod
    def avg(numbers: list) -> float:
        """
        Рассчитывает среднее значение каждого списка.
        """
        if not isinstance(numbers, list):
            raise ValueError("Expected list object")
        if len(numbers) == 0:
            return 0
        numbers_sum = 0
        for num in numbers:
            if not isinstance(num, int):
                raise ValueError("List must contain only int numbers")
            numbers_sum += num
        return numbers_sum / len(numbers)

    @staticmethod
    def avg_compare(list_1: list, list_2: list, avg_method: callable = avg) -> str:
        """
        Сравнивает эти средние значения и выводит соответствующее сообщение
        """
        compare_result = avg_method(list_1) - avg_method(list_2)
        if compare_result > 0:
            result_str = "Первый список имеет большее среднее значение"
        elif compare_result < 0:
            result_str = "Второй список имеет большее среднее значение"
        else:
            result_str = "Средние значения равны"
        return result_str
