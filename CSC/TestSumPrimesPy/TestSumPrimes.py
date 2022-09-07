from SumPrimes import sumPrimes

import unittest

class TestSumPrimes(unittest.TestCase) :

    # Would it help to have these as separate test methods?

    def test_sumPrimes(self):
        assert sumPrimes(1) == 0, "1 case"
#         assert sumPrimes(2) == 2, "2 case"
#         assert sumPrimes(3) == 5, "3 case"
#         assert sumPrimes(4) == 5, "4 case"
#         assert sumPrimes(10) == 17, "10 case"
#         assert sumPrimes(11) == 28, "11 case"
#         assert sumPrimes(12) == 28, "12 case"

if __name__ == '__main__':
    unittest.main()
