Windows Installer
=================
This folder contains everything necessary to build a Windows installer.

Refs
----
- http://wix.tramontana.co.hu/
- http://sanathshenoy.blogspot.com/2011/09/deploying-java-application-with-wix.html
- http://sanathshenoy.blogspot.com/2011/09/deploying-java-application-with-wix.html

Building the Installer
----------------------
The following utilities are required to perform the build:
  WiX
  JSmooth
  RCEdit (from https://github.com/atom/rcedit - install into C:\Utilities)

- Commands to build the installer (run in this sequence).  Note that the full path to the .jsmooth
  configuration file appears ot be required.  Update "PATH_TO_WINDOWS_FOLDER" as necessary:
  Build WebShortcutLaunch.jar and put it into the "windows/res" folder.
  cd windows
  mkdir build
  "C:\Program Files (x86)\JSmooth 0.9.9-7\jsmoothcmd" PATH_TO_WINDOWS_FOLDER\WebShortcutLaunch.jsmooth
  C:\Utilities\rcedit build\WebShortcutLaunch.exe --set-icon "res\WebShortcut.ico"
  "C:\Program Files (x86)\WiX Toolset v3.9\bin\candle" WebShortcutTools.wxs
  "C:\Program Files (x86)\WiX Toolset v3.9\bin\light" -ext WixUIExtension WebShortcutTools.wixobj
  ren WebShortcutTools.msi WebShortcutTools_0.1.1-1.msi

- To clean up:
  del build\*.*
  rmdir build
  del *.wixobj
  del *.wixpdb

Notes
-----
- To generate 20 UUID's in Ubuntu:
  seq 20 | xargs -i uuidgen
- I originally tried to install and run the jar directly without converting it to an exe.
  However, I had issues with creating the file associations.  I was able to get file associations
  to work by using a batch script, but I could not figure out how to run the script without
  a command window popping up each time.  It seemed like a losing battle, so I wrapped the
  jar in an exe.
- For wrapping the jar into an exe, I used JSmooth.  This has not been updated in years, but
  seems to work well.
- JSmooth gave an error when I tried to embed the ICO.  I am not sure if there is an issue with
  the ICO, or if it is a compatibility issue due to JSmooth's age.  So, I used RCEdit to embed
  the ICO.