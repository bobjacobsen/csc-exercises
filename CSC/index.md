# Index of Tools Exercises

Please read this all the way through first, to get an idea
of the overall plan of the exercises. Note that there are some
general notes at the bottom of this page.


## Getting Started
The very first step is get a partner to work with.  You can change, and teams often do, but it's much better to work with somebody than to try to learn alone.

These exercises involve some minimal Java, Python and/or C++ programming. We recommend that you arrange yourself in groups so that somebody in each group has at least a little experience with Java, Python and/or C++.


Next, get the School's virtual machine installed and running on your laptop, and then log in.
For more information on how to do that, see the School's
<a href="https://indico.cern.ch/event/769356/page/15184-laptop-configuration">Laptop configuration page</a>.

Then open a Terminal window and get
a copy of the exercise files:
```
cd ~
git clone https://github.com/bobjacobsen/csc-exercises.git
```
Do a bit of setup (this only has to be done once):
```
source csc-exercises/CSC/setup
```

Finally, tell us who makes up your team, so we can find you later with updates:
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

1: [TestIntroJava](TestIntroJava/index.md) - brief demo of using JUnit for Java code testing. We put this first because JUnit is perhaps the simplest of the unit testing frameworks.

2: [TestIntroPy](TestIntroPy/index.md) - brief demo of using PyUnit for Python code testing.

3: [TestIntroCpp](TestIntroCpp/index.md) - brief demo of using CppUnit for C++ code testing. Will benefit from a bit of C++ experience with header files, etc, but can be done without it.

We then move forward to a more significant example, the SumPrimes code from lecture.  Do one or two of the following. (If you speak all three languages, you could do all three, but that's very optional)

4: [TestSumPrimesJava](TestSumPrimesJava/index.md) -

5: [TestSumPrimesPy](TestSumPrimesPy/index.md) -

6: [TestSumPrimesCpp](TestSumPrimesCpp/index.md) -


## Performance Profiling

They demonstrate how tools, even simple ones can help you focus on in where time is really being spent.
We recommend you do at least one of these.
If you've already worked with performance tools, you can perhaps skip these; if not, they might get you thinking a bit.


7: [ProfileStatsJava](ProfileStatsJava/index.md) Practice tuning a small Java application

8: [ProfileStatsCpp](ProfileStatsCppindex.md) Practice tuning a small C++ application


## Memory Issues

People with experience programming C and C++ close to the hardware might find this a little basic (though the valgrind tool can be  useful even for experts). Everybody else should definitely do this one to learn more about how memory really works.

5: [MemIntroCpp](MemIntroCpp/index.md) - Testing for C++ memory faults

-- -- --

## Code Management

Depending on your level of experience, these are all optional.  People who just use `git` by recipe or want a better understanding of the basics, including how to use it locally for your own individual work, would probably benefit most from the first two.  People with more experience might find the more advanced topics in the 2nd two interesting.

N: <A HREF="GitBasics1/intro.md">GitBasics1</a> Simple use of git - basic introduction, so if you have git experience you might want to quickly read through this for things you haven't seen (do you know what `git add --patch` does?)

N: <A HREF="GitBasics2/index.md">GitBasics2</a> Demonstration of Git branching - also basic. Good introduction for people who haven't done much branching and merging on their own, but optional for people who have.

N: <A HREF="GitBisect/index.md">GitBisect</a> Introduction to the use of `git bisect` to track down where an error was introduced, `git blame` to know who to consult about a fix, and your options for handling the error.

N: <A HREF="GitHeadBanging/index.md">GitHeadBanging</a> You've committed something that maybe you shouldn't.  What are your options now, beyond the XKCD "delete and download a new one"?

(`git rebase` needs to be here somewhere; from G3 - can it rebase away the error in Bisect?)



## Corrections

If there are any last-minute corrections to the instructions,
we will post them in the exercise room and on this [Google Doc](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing). To update your local copy, do
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
<a href="https://github.com/bobjacobsen/csc-exercises/releases/CSC-2022">CSC-2022</a> release tag.

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
 - A writeup on how to <a href="https://git.wiki.kernel.org/index.php/GitSvnCrashCourse">convert your SVN thinking</a> to Git;
see also a
<a href="http://git.or.cz/course/svn.html">slightly older but more readable version</a>.

The web has lots of talks and tutorials on more advanced Git topics.

</body>
</html>