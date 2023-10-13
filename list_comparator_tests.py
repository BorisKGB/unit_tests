import pytest
from unittest.mock import MagicMock
from list_comparator import ListComparator


@pytest.mark.parametrize("numbers, expected", [
    ([1, 2, 3], 2),
    ([1, 1, 1], 1),
    ([], 0)
])
def test_avg_correct(numbers, expected):
    assert ListComparator.avg(numbers) == expected


def test_fail_on_incorrect_input():
    with pytest.raises(ValueError):
        ListComparator.avg("text")


def test_fail_on_incorrect_list_element():
    with pytest.raises(ValueError):
        ListComparator.avg([1, 2, "3"])


@pytest.mark.parametrize("list_1, list_2, expected", [
    ([1, 2], [1, 1], "Первый список имеет большее среднее значение"),
    ([1, 2], [3, 1], "Второй список имеет большее среднее значение"),
    ([], [], "Средние значения равны")
])
def test_compare_string_correct(list_1, list_2, expected):
    assert ListComparator.avg_compare(list_1, list_2) == expected


def test_valid_method_usage():
    tst_method = MagicMock(return_value=1)
    ListComparator.avg_compare([], [], avg_method=tst_method)
    assert tst_method.call_count == 2

