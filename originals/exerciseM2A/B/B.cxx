#include "B.h"
#include "A.h"

void B::print ()
{
        A a;
        a.print();
        cout<<"Hello from B"<<endl;
}
