""" 
@author: mces58

Problem 54
In the card game poker, a hand consists of five cards and are ranked, from
lowest to highest, in the following way:

High Card: Highest value card.
One Pair: Two cards of the same value.
Two Pairs: Two different pairs.
Three of a Kind: Three cards of the same value.
Straight: All cards are consecutive values.
Flush: All cards of the same suit.
Full House: Three of a kind and a pair.
Four of a Kind: Four cards of the same value.
Straight Flush: All cards are consecutive values of same suit.
Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.

The cards are valued in the order:
2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.

If two players have the same ranked hands then the rank made up of the
highest value wins; for example, a pair of eights beats a pair of fives (see
example 1 below). But if two ranks tie, for example, both players have a pair
of queens, then highest cards in each hand are compared (see example 4
below); if the highest cards tie then the next highest cards are compared,
and so on.

Consider the following five hands dealt to two players:
Hand		Player 1			Player 2				Winner
1		5H 5C 6S 7S KD		2C 3S 8S 8D TD			Player 2
			Pair of Fives		Pair of Eights
2		5D 8C 9S JS AC		2C 5C 7D 8S QH			Player 1
			Highest card Ace	Highest card Queen
3		2D 9C AS AH AC		3D 6D 7D TD QD			Player 2
			Three Aces			Flush with Diamonds
4		4D 6S 9H QH QC		3D 6D 7H QD QS			Player 1
			Pair of Queens		Pair of Queens
			Highest card Nine	Highest card Seven
5		2H 2D 4C 4D 4S		3C 3D 3S 9S 9D			Player 1
			Full House			Full House
			With Three Fours	with Three Threes

The file, poker.txt, contains one-thousand random hands dealt to two players.
Each line of the file contains ten cards (separated by a single space): the
first five are Player 1's cards and the last five are Player 2's cards. You
can assume that all hands are valid (no invalid characters or repeated
cards), each player's hand is in no specific order, and in each hand there is
a clear winner.

How many hands does Player 1 win?

Answer: 376
"""

import itertools
from typing import Optional


def testWithExamples() -> None:
    assert not player1Wins("5H 5C 6S 7S KD 2C 3S 8S 8D TD")
    assert player1Wins("5D 8C 9S JS AC 2C 5C 7D 8S QH")
    assert not player1Wins("2D 9C AS AH AC 3D 6D 7D TD QD")
    assert player1Wins("4D 6S 9H QH QC 3D 6D 7H QD QS")
    assert player1Wins("2H 2D 4C 4D 4S 3C 3D 3S 9S 9D")


def mapValue(value: str) -> int:
    try:
        return int(value)
    except ValueError:
        return {"T": 10, "J": 11, "Q": 12, "K": 13, "A": 14}[value]


def parseHand(hand: str) -> list[tuple[int, str]]:
    cards = hand.split()
    return [(mapValue(pair[0]), pair[1]) for pair in cards]


def player1Wins(line: str) -> bool:
    cards = parseHand(line.strip())
    hand1 = cards[:5]
    hand2 = cards[5:]
    hand1.sort()
    hand2.sort()
    rating1 = rateSpecialHand(hand1)
    rating2 = rateSpecialHand(hand2)
    return rating1 > rating2


def rateSpecialHand(hand: list[tuple[int, str]]) -> int:
    predicates = [
        isHighCard,
        isOnePair,
        isTwoPairs,
        isThreeOfAKind,
        isStraight,
        isFlush,
        isFullHouse,
        isFourOfAKind,
        isStraightFlush,
        isRoyalFlush,
    ]
    for index, predicate in reversed(list(enumerate(predicates))):
        if result := predicate(hand):
            return [index, predicate.__name__] + result


def isHighCard(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    return sorted((value for value, suit in hand), reverse=True)


def groupCardValues(hand: list[tuple[int, str]]) -> list[list[int]]:
    values = [value for value, suit in hand]
    values.sort(reverse=True)
    groups = [list(group) for key, group in itertools.groupby(values)]
    groups.sort(key=lambda group: (len(group), group[0]), reverse=True)
    return groups


def flatten(xss: list[list[int]]) -> list[int]:
    return [x for xs in xss for x in xs]


def isOnePair(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    groups = groupCardValues(hand)
    if len(groups[0]) == 2:
        return flatten(groups)


def isTwoPairs(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    groups = groupCardValues(hand)
    if len(groups[0]) == 2 and len(groups[1]) == 2:
        return flatten(groups)


def isThreeOfAKind(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    groups = groupCardValues(hand)
    if len(groups[0]) == 3:
        return flatten(groups)


def isStraight(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    values = [value for value, suit in hand]
    values.sort(reverse=True)
    expected = list(reversed(range(min(values), max(values) + 1)))
    if values == expected:
        return values


def isFlush(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    if len({suit for value, suit in hand}) == 1:
        return sorted((value for value, suit in hand), reverse=True)


def isFullHouse(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    groups = groupCardValues(hand)
    if len(groups[0]) == 3 and len(groups[1]) == 2:
        return flatten(groups)


def isFourOfAKind(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    groups = groupCardValues(hand)
    if len(groups[0]) == 4:
        return flatten(groups)


def isStraightFlush(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    if isStraight(hand):
        return isFlush(hand)


def isRoyalFlush(hand: list[tuple[int, str]]) -> Optional[list[int]]:
    if max(value for value, suit in hand) == 14:
        return isStraightFlush(hand)


def solution() -> int:
    winsPlayer1 = 0
    with open("poker.txt") as f:
        for line in f:
            if player1Wins(line):
                winsPlayer1 += 1
    return winsPlayer1


result = solution()

print(result)
