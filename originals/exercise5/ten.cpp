#include <iostream>
using namespace std;
int main()
{
  
  int *ptr;
  
  cout << "Hello World!" << endl;   

  cout << "Value is " << *ptr << endl;

  ptr = new int;
  
  delete ptr;

  *ptr = 10;

  cout << "Done" << endl;

}
