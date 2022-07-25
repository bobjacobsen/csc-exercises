#include <iostream>
using namespace std;
int main()
{
  
  int *ptr;
  
  cout << "Hello World!" << endl;   

  ptr = new int;
  
  *ptr = 7;
  
  {
    ptr = new int;
  
    *ptr = 8;
  
    cout << "Inner value is " << *ptr << endl;

    delete ptr;
  }
  
  cout << "Outer value is " << *ptr << endl;
  
  delete ptr;
    
  cout << "Done" << endl;

}
