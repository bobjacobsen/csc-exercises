## MemIntroCpp: Testing for C++ Memory Faults

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Gain some experience with types of memory faults and tools that can help with them.

As you work through here, you may find some things that are puzzling.  It's OK to ask!  There are also some useful references in
<a href="https://docs.google.com/document/d/1Jvb1zYRibzOw74VKnGsmTVfWkQcOxb_yc8JboebFDpA/edit#heading=h.dwvcizbspysp">The Bibliography</a>,
particularly the
<a href="https://docs.google.com/document/d/1Jvb1zYRibzOw74VKnGsmTVfWkQcOxb_yc8JboebFDpA/edit#heading=h.dwvcizbspysp">section on "Memory Issues"</a>.

First, create a local copy of the exercise files.
```
    cd MemIntroCpp
    source setup.sh
```

(Note to people using this on their own machines: This will overwrite your ~/.valgrind configuration file if you already have one)

Three are twelve simple C++ programs in files named "one.cpp" through "twelve.cpp".

To run the first one, do:

```
   g++ -g2 one.cpp
   ./a.out
```

(The -g2 option ensures that debugging info is kept for later)

It should almost immediately print a result and quit:

```
   % ./a.out
   Hello World!
   Value is 1
   Done
   %
```

If you open the source file in your favorite editor, you'll see that this is really simple code.

Programs two.cpp through twelve.cpp all take slightly different approaches and are meant to print similar, but not identical things.  Look through each of them and make a table of the answers to two questions for each one:

 - What will it print? I.e. will it print it's own number?
 - Are there any memory management errors in the program?

Is it possible for a program with an error to still print the right answer? Which do that?

Your table should look something like this. (We'll fill out the right 3 columns below)
<table border="1">
<tr>
<th>Name</th><th>Expected<br>Output</th>
<th>Errors To <br/>Be Captured</th>
<th>Run with<br/>MALLOC_CHECK_<br/>= 0</th>
<th>Run wtih<br/>MALLOC_CHECK_<br/>= 1</th>
<th>Run with<br/>Valgrind</th>
</tr>
<tr><td>One</td><td>1</td><td>None</td><td></td><td></td><td></td></tr>
<tr><td>Two</td><td>2</td><td>??</td><td></td><td></td><td></td></tr>
<tr><td>...</td><td></td><td></td><td></td><td></td><td></td></tr>
<tr><td>...</td><td></td><td></td><td></td><td></td><td></td></tr>
<tr><td>...</td><td></td><td></td><td></td><td></td><td></td></tr>
<tr><td>Twelve</td><td>12, then 11, etc</td><td>??</td><td></td><td></td><td></td></tr>
</table>

Once you have your list,

```
   export MALLOC_CHECK_=0
```
(the underscores are important), or if you're using a C-style shell do:
```
   setenv MALLOC_CHECK_ 0
```

and run each of the programs and see if the program's results agree with your predictions

Even if a memory error doesn't cause trouble for the printout or prevent the program from terminating normally, we'd still like to find them and fix them before they bite somebody else. Doing it by inspecting the code is difficult, so we'd like automated help.

Let's try the checks that the memory allocator can do on it's own.
Do this:

```
   export MALLOC_CHECK_=1
```
(the underscores are important), or if you're using a C-style shell do:
```
   setenv MALLOC_CHECK_ 1
```

Now rerun each of the programs and figure out which errors are caught by this, and which are not.

To make running all the tests a little faster, we've provided a script that compiles and runs them all:

```
./all.sh "g++ -g2"
```

(the quotes are important)

malloc is only involved with allocation and return of memory, and generally can't find problems with the actual memory references themselves. valgrind, on the other hand, can check every memory reference if told to. We'll try that next.

Rerun each program under the scrutiny of valgrind:

 ```
   g++ -g2 one.cpp
   valgrind ./a.out
 ```

Or, to run them all:

```
./all.sh "g++ -g2" valgrind
```

Look at each output carefully to see what error(s) valgrind has found.  Did it find any that you missed? Did it miss any that you found?  It not only checks for validity of references, it also checks for a number of different kinds of memory leaks.
