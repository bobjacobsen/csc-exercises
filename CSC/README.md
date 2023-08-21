# Index of Tools Exercises

Please read this all the way through first, to get an idea
of the overall plan of the exercises. Note that there are some
general notes at the bottom of this page.


## Getting Started
The very first step is get a partner to work with.  You can change, and teams often do, but it's much better to work with somebody than to try to learn alone.

These exercises involve some minimal Java, Python and/or C++ programming. We recommend that you arrange yourself in groups so that somebody in each group has at least a little experience with Java, Python and/or C++.

Next sign into the CERN LXPlus8 cluster:

```
ssh -X youraccountname@csc-2023-XX.cern.ch
```

The -X option should forward X11 windows back to your machine.  (We use LXPlus8 because we know that environment would work.  In theory, you could also work on your own machine, but you'll probably need to do some configuration and installations)

Then get a copy of the exercise files:
```
cd ~
git clone https://github.com/bobjacobsen/csc-exercises.git

```
Do a bit of setup (this has to be done every time you login or open a new terminal window):
```
cd csc-exercises/CSC
source setup
```

Finally, tell us who makes up your team, so we can find you later with updates (only needed once):
```
./csc_log team "One Student Name" "Other Student Name"
```

## About the Exercises

There is no particular time expected for these exercises. You should do them in order, but it's OK to spend more time on the ones that interest you and go quickly through others.  It's completely fine to skip the ones marked "optional".

Nobody does every bit of every exercise, and that's OK.

If you run out of time and want to do more on particular topics, you can come back to these topics later in the week. They can be run anywhere.  But please don't feel compelled to work on these after the scheduled sessions; there is a lot more to the School!

If there are any problems or updates to the exercises, we'll post announcements to a [Google doc](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit) and display them on a screen in the exercise room for your reference.

A short comment on structure: Some of these exercises start by asking you to create a directory by unpacking a .tar file.  We do this so that because putting a Git repository inside another Git repository can get very complicated.

You can't break anything, so please feel free to experiment!

## Test Frameworks

You should do all three of the these first exercises to work with test frameworks
and make sure that your exercise environment is working correctly.
Each is a little bit different. Please do

1: [TestIntroJava](TestIntroJava/README.md) - brief demo of using JUnit for Java code testing. We put this first because JUnit is perhaps the simplest of the unit testing frameworks.

2: [TestIntroPy](TestIntroPy/README.md) - brief demo of using PyUnit for Python code testing.

3: [TestIntroCpp](TestIntroCpp/README.md) - brief demo of using CppUnit for C++ code testing. Will benefit from a bit of C++ experience with header files, etc, but can be done without it.

We then move forward to a more significant example, the SumPrimes code from lecture.  Do two of the following. (If your team speaks all three languages, you could do all three, but that's optional)

4: [TestSumPrimesJava](TestSumPrimesJava/README.md) - SumPrimes in Java

5: [TestSumPrimesPy](TestSumPrimesPy/README.md) - SumPrimes in Python

6: [TestSumPrimesCpp](TestSumPrimesCpp/README.md) - SumPrimes in C++

## Performance Profiling

These demonstrate how tools, even simple ones, can help you focus on in where time is really being spent.
We recommend you do at least one of these. Doing both is optional; the second one you do will go pretty quickly as you'll know where the problems are.

7: [ProfileStatsJava](ProfileStatsJava/README.md) Practice tuning a small Java program

8: [ProfileStatsCpp](ProfileStatsCpp/README.md) Practice tuning a small C++ program


## Memory Issues

People with experience programming C and C++ close to the hardware might find this a little basic (though the valgrind tool can be  useful even for experts). Everybody else should definitely do this one to learn more about how memory really works.

9: [MemIntroCpp](MemIntroCpp/README.md) - Testing for C++ memory faults


## Git Practice

Depending on your level of experience, these are all optional.  People who just use `git` by recipe or want a better understanding of the basics, including how to use it locally for your own individual work, would probably benefit most from the first two.  People with more experience might find the more advanced topics in the last three interesting. Doing the GitBisect exercise is recommended for everyone.

10: [GitBasics1](GitBasics1/README.md) - Simple use of git - basic introduction, so if you have git experience you might want to quickly scan through this for things you haven't seen (do you know what `git add --patch` does?)

11: [GitBasics2](GitBasics2/README.md) - Demonstration of Git branching - also basic. Good introduction for people who haven't done much branching and merging on their own, but optional for people who have.

12: [GitBisect](GitBisect/README.md) - Introduction to the use of `git bisect` to track down where an error was introduced, and your options for handling the error.

13: [GitRecovery](GitRecovery/README.md) - Managing the head of your branches. For example, you've committed something that maybe you shouldn't have.  What are your options now, beyond the XKCD "delete and download a new one"?

14: [GitHistory](GitHistory/README.md) - Covers the tools for creating a linear history in Git:  squashing and rebasing.

## Corrections

If there are any last-minute corrections to the instructions,
we will post them in the exercise room and on this [Google Doc](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing). To update your local copy of these exercises, do
```
    cd ~/csc-exercises
    git pull
    cd
```
and then refresh your web browser windows to pick up the new instructions.

## Files

Updated PDF files are available for
<a href="https://indico.cern.ch/event/1125271/contributions/4723302/">lecture 1</a> and
<a href="https://indico.cern.ch/event/1125271/contributions/4723247/">lecture 2</a> in Indico.

We continually update the exercises in GitHub.
After the School is complete, you can get the specific version we used
by looking for the
<a href="https://github.com/bobjacobsen/csc-exercises/releases/CSC-2023">CSC-2023</a> release tag.

## General notes:

Note that the instructions for these exercises are written for a Bash-type shell.  If you use a C-type shell:
<OL>
<LI>Replace "export SOMETHING=..." with "setenv SOMETHING ..."
<LI>Replace "source setup.sh" with "source setup.csh"
</OL>


Style convention:  Indented commands in <code>code font</code> are meant to
be cut and pasted into a command line:
```
    cd
    echo "Done!"
```
When we want to show the output from a command, we'll include the command prompt:
```
$date
Thu June 15 10:37:13 PDT 2018
```
That's not meant to be cut-and-pasted in its entirety, just the parts
after the $ or % command prompt.

<h2 id="biblio">Bibliography</h2>

The bibliography is kept in a
<a href="https://docs.google.com/document/d/1Jvb1zYRibzOw74VKnGsmTVfWkQcOxb_yc8JboebFDpA/edit#">Google Doc</a>.
It is periodically updated as cool new things are found.

<h2>For more information</h2>
For more information on Java math routines like floor(...), sqrt(...), etc
please see the
<a href="http://download.oracle.com/javase/8/docs/api/java/lang/Math.html">Math class doc page</a>.

For more information on the JUnit unit test classes for Java, see their
<a href="http://junit.sourceforge.net/javadoc/">class documentation</a>.

For more information on the CppUnit unit test classes for C++, see their
<a href="http://cppunit.sourceforge.net/doc/1.8.0/">web page</a>.

For more information on valgrind, see their
<a href="http://valgrind.org/docs/">documentation page</a>.

Information on Git:

 - The <a href="https://www.kernel.org/pub/software/scm/git/docs/">detailed Git documentation</a>.
 - Lots of <a href="http://gitready.com">questions and answers</a> on Git usage.

The web has lots of talks and tutorials on more advanced Git topics.

</body>
</html>
