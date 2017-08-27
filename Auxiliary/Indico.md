The very first step is get the School's virtual machine installed and running on your laptop, and then to log in.
For more information on how to do that, see the School's [Laptop configuration page](https://indico.cern.ch/event/581756/page/9650-laptop-configuration).

To start the exercises, open a Terminal window on your machine and do:

    cd
    git clone https://github.com/bobjacobsen/csc-exercises.git

(that might take a minute) then do:

    source csc-exercises/CSC/setup

The result should look something like this (numbers may vary, don't worry about that):
```
[csc_me@CSC2017 ~]$ git clone https://github.com/bobjacobsen/csc-exercises.git
Cloning into 'csc-exercises'...
remote: Counting objects: 569, done.
remote: Compressing objects: 100% (20/20), done.
remote: Total 569 (delta 9), reused 16 (delta 4), pack-reused 545
Receiving objects: 100% (569/569), 94.67 MiB | 3.38 MiB/s, done.
Resolving deltas: 100% (362/362), done.
[csc_me@CSC2017 ~]$ source csc-exercises/CSC/setup
[csc_me@CSC2017 ~]$ 
```

Finally, open the CSC/index.html file in your favorite web browser and follow those instructions.
This will be a URL something like [file:///home/csc_me/CSC/index.html](file:///home/csc_me/CSC/index.html), though you'll have to put your own account name in there.
