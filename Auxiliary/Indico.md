The very first step is get the School's virtual machine installed and running on your laptop, and then to log in.
For more information on how to do that, see the School's [Laptop configuration page](http://csc.web.cern.ch/Laptop-Exercises-Requirements).

To start the exercises, open a Terminal window on your machine and do:

````
cd
git clone https://github.com/bobjacobsen/csc-exercises.git
````
(that might take a minute) then do:
````
source csc-exercises/CSC/setup
````

The result should look something like this (numbers may vary):
````
[csc_me@CSC2016 ~]$ git clone https://github.com/bobjacobsen/csc-exercises.git
Cloning into 'csc-exercises'...
remote: Counting objects: 385, done.
remote: Compressing objects: 100% (23/23), done.
remote: Total 385 (delta 9), reused 0 (delta 0), pack-reused 362
Receiving objects: 100% (385/385), 94.64 MiB | 2.73 MiB/s, done.
Resolving deltas: 100% (233/233), done.
Checking connectivity... done.
[csc_me@CSC2016 ~]$ source csc-exercises/CSC/setup
[csc_me@CSC2016 ~]$ 
````

Finally, open the CSC/index.html file in your favorite web browser and follow those instructions.
This will be a URL something like [file:///home/csc_me/CSC/index.html](file:///home/csc_me/CSC/index.html), though you'll have to put your own name in there.
