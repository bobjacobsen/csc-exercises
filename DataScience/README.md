# CSC Data Science Exercises

Please read this all the way through first to get a idea of the overall plan of the exercises.  Note that there's some general information at the end.

## Getting Started

We use the CERN SWAN service for these exercises.  You should already have an account.

To access SWAN, go to
[https://swan.cern.ch](https://swan.cern.ch)
and login using your CERN account. Note:  If you don't already have a CERNbox account, you'll need to create one.  If needed, the SWAN logon process will give you a link to do this.

Select 105a in the "Software stack" selector.
Make sure the "Use Python packages installed on CERNBOX" box is checked.
Click "Start my Session" at the bottom right.
Wait for your session to start. This might take a minute or so.

If the sign-on fails, a possible cause is that your CERNbox account is not initialized.  Check the error message.  If it provides a link to follow to CERNbox, please do that and start your CERNbox account before retrying SWAN again.

When you get to the "My Projects" screen, click the "Download project from git" link (a small cloud&arrow at the upper right) and enter
```
  https://github.com/bobjacobsen/csc-exercises.git
```
Click download _once_, then wait for the download to complete.  It might take a couple minutes. Please feel free to read ahead in the instructions!

Once the download is complete, you'll see a "csc-exercises" directory.  Click that to open it. These exercises are in the DataScience directory within the csc-exercises directory you just checked out. Click that to open it and then click the "setup.ipynb" notebook to open it. That makes sure that a consistent set of necessary packages is installed so that you can do these exercises.  Click the ">" run button until you get to the end (the first block will likely produce a lot of output; let it run until the cursor moves to the 2nd block) Once that's successfully completed the imports in block two, you can close that window and go back to the directory listing.

## About the Exercises

There are three categories: Introductory, Intermediate and Advanced.

To do each exercise, navigate SWAN to the folder for the exercise, then launch the .ipynb file found there.  For example, click on the "OldFaithful" folder, then on the "OldFaithful.ipynb" file.

Instructions are embedded in each file. For some exercises, there are also data files that you can browse by opening them in SWAN. The Introductory and Intermediate exercises have "*Solution" notebooks you can open if you get stuck.

If there are any problems or updates to the exercises, we'll post announcements to a [Google doc](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit) and display them on a screen in the exercise room for your reference.


### Introductory

These are meant to be an good starting point to make sure that your technical setup is working and to give you familiarity with Jupyter notebooks and analysis packages. Be sure to do the first one ("Old Faithful") to make sure everything is working, then do at least  two or three of the following ones that you find interesting.

Each has some additional calculations and questions at the end, beyond what we did in lecture, for your exploration and enjoyment.

A lot of analysis code is written by copy-and-paste from prior notebooks (and sometimes from [StackOverflow](https://stackoverflow.com/questions/66675146/calculate-the-difference-between-pandas-rows-in-pairs)...).  Even if you skip doing some of these, you might want to open them to copy how to make a particular calculation or plot.

_Old Faithful_

This is the Jupyter Notebook that started the lectures. To start, just work through each cell:  Look at it, decide what it will do, then run it.  Once you get toward the bottom, you're prompted to use the same ideas to answer a few more questions from the data.
Note there's also a version that uses Pandas so you can compare them if you want.

_Toast_

Introduction to simulating a distribution.

_Juries_

Simulating multi-dimensional distributions.

_Drinks_

Intro to joining separate data-sets together.

_Bikes_

More joining and multi-dimensional statistics, followed by mapping of geographic data.

(The second half of this might have been better in the Intermediate category)

_LittleWomen_

Searching and counting in a text data set.


### Intermediate

These are meant to give you more experience with analysis. Please feel free to spend as much as or as little time as you'd like on these.  If you think of other questions you'd like to answer from the data, go ahead and do that!

_Movies_

Examining some categorical/numerical information about actors and movies.

_Census 1 and Census 2_

Analysis of census and tax information, first numerically, then with added GIS information.

### Advanced/Optional

If you have time, there are some optional projects where you can try out these techniques on more interesting problems with larger data sets.

In the `Projects` directory you will find several project subdirectories. In order of increasing depth and size, these are:

0) Use some SCADA data to check the health of a cooling system

1) An examination of global demographics

2) An examination of heart health and disease (Really Advanced, experience recommended)

3) Building a movie classifier (Really Advanced, experience recommended)

Each of these is a mix of pre-provided computations, explanations, and cells that you have to fill out.  The first one (SCADA) is somewhat self-directed and open-ended; the last three are more step-by-step, but much larger.

Pick one that sounds interesting and get as far as you can on it.  Don't worry about completing them, they're significant projects that are likely to more than fill the exercise period.

## General Information

If you want to run these on your own machine, first install Jupyter Notebooks.  There are several ways to do this, but perhaps the most straight-forward is to [use PIP](https://jupyter.org/install).  Then checkout the exercise material to your machine. During the CERN School, please use the head of the `master` branch.  After the School is over, you can checkout the `CSC-2024` tag to get exactly these exercises. Finally, run the top-level `setup` notebook to make sure you have the right libraries installed.

### Files

An updated PDF file is available for the [lecture](https://indico.cern.ch/event/1376644/contributions/5945384/) in Indico.

We continually update the exercises in GitHub. After the School is complete, you can get the specific version we used by looking for the
<a href="https://github.com/bobjacobsen/csc-exercises/releases/CSC-2024">CSC-2024</a> release tag.


### Documentation

 - [`numpy` package](https://numpy.org/doc/)

 - [`pandas` package](https://pandas.pydata.org/docs/)
   - [API reference](https://pandas.pydata.org/docs/reference/index.html#api)

 - [`datascience` package](http://data8.org/datascience/index.html)
    - [Manual](https://readthedocs.org/projects/datascience/downloads/pdf/master/)
    - [Maps]{http://data8.org/datascience/maps.html}

 - [`matplotlib` package](https://matplotlib.org/stable/index.html)

 ### Data

 One good source of data sets is [Google Dataset Search](https://datasetsearch.research.google.com).  For more, see [this blog entry](https://www.blog.google/products/search/making-it-easier-discover-datasets/).

