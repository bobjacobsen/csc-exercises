#include "C.h"
#include "B.h"

void C::print ()
{
        B b;
        b.print();
        cout<<"Hello from C"<<endl;
}
