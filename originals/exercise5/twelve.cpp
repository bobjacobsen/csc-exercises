#include <iostream>
using namespace std;
int main()
{

  int LENGTH = 16;
  
  int* a = new int[LENGTH];
  int* b = new int[LENGTH];
  
  cout << "Hello World!" << endl;   

  for (int i=0; i<LENGTH; i++) a[i] = 11;
  for (int i=0; i<LENGTH; i++) b[i] = 12;

  cout << "Value of a[LENGTH] is " << a[LENGTH] << endl;
  cout << "Value of b[LENGTH] is " << b[LENGTH] << endl;

  a[LENGTH] = 110;
  b[LENGTH] = 120;

  cout << "New value of a[LENGTH] is " << a[LENGTH] << endl;
  cout << "New value of b[LENGTH] is " << b[LENGTH] << endl;
   
  delete[] b;
  delete[] a;
  
  cout << "Done" << endl;

}
