import unittest
from SampleClass import SampleClass

class TestSampleClass(unittest.TestCase):

    def test_state(self):
        dut = SampleClass()
        dut.setState(2)
        self.assertEqual(dut.getState(), 2)
        dut.setState(34)
        self.assertEqual(dut.getState(), 34)

    def test_one_more(self):
        dut = SampleClass()
        self.assertEqual(dut.saveThenReturnOneMore(1), 2)
        self.assertEqual(dut.getState(), 1)

    def test_one_less(self):
        dut = SampleClass()
        self.assertEqual(dut.saveThenReturnOneLess(3), 2)
        self.assertEqual(dut.getState(), 3)

if __name__ == '__main__':
    unittest.main()