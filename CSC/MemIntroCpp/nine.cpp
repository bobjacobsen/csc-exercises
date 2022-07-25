#include <iostream>
using namespace std;
int main()
{
  
  int *ptr;
  
  cout << "Hello World!" << endl;   

  ptr = new int;
  
  delete ptr;

  *ptr = 9;
  
  cout << "Value is " << *ptr << endl;
    
  cout << "Done" << endl;

}
