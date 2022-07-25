#include "SumPrimes.cpp"

#include <iostream>
#include <sstream>

int main(int argc, char *argv[]) {

    if (argc < 2) {
        std::cerr << "Takes one argument, the top number to be scanned for primes" << std::endl;
        return -1;
    }
    std::istringstream ss(argv[1]);
    int topVal;
    if (!(ss >> topVal)) {
      std::cerr << "Invalid number: " << argv[1] << '\n';
      return -2;
    } else if (!ss.eof()) {
      std::cerr << "Trailing characters after number: " << argv[1] << '\n';
      return -3;
    }

    std::cout << sumPrimes(topVal) << std::endl;

}
