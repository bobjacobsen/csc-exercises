#include <iostream>
using namespace std;
int main()
{
  
  int *ptr;
  
  cout << "Hello World!" << endl;   

  ptr = new int;
  
  *ptr = 8;
  
  {
    int* ptr = new int;
  
    *ptr = 9;
  
    cout << "Inner value is " << *ptr << endl;

    delete ptr;
  }
  
  cout << "Outer value is " << *ptr << endl;
  
  delete ptr;
    
  cout << "Done" << endl;

}
