"""
@author: mces58

Problem 19
You are given the following information, but you may prefer to do some research for yourself.

* 1 Jan 1900 was a Monday.

* Thirty days has September,
April, June and November.
All the rest have thirty-one,
Saving February alone,
Which has twenty-eight, rain or shine.
And on leap years, twenty-nine.

* A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.

How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

Answer : 171
"""

from datetime import datetime, timedelta

# Start date is January 1, 1901
startDate = datetime(1901, 1, 1)

# End date is December 31, 2000
endDate = datetime(2000, 12, 31)

# Counter is defined to count the number of Sundays
sundays = 0

while startDate <= endDate:

    # If the day is the first of the month and the day is Sunday
    if startDate.day == 1 and startDate.weekday() == 6:
        sundays += 1

    # Add 1 day to mark the next day
    startDate += timedelta(days=1)

print(sundays)
