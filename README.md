Web Shortcut (Java Application)
====================================

Summary
-------
Java application which launches web shortcuts files.

This application may not work with all operating systems.
Due to differences in operating systems, it is difficult for
Java to open a browser in a 100% reliable way.
I attempted to use the BrowserLauncher2 library, but had difficulties.
Due to time constraints, I just used a custom-built launching algorithm
(with some help from this blog entry:
http://www.mkyong.com/java/open-browser-in-java-windows-or-linux/ )

Notes
-----
- Currently there is only a standalone jar for launching shortcuts.
- The launcher does not appear to work on Windows with files with unicode
  characters (it gives a file not found exception).
- the build script for the WebShortcut Android app icons also creates
  icons compatible for Windows and Linux.  Although they are not included
  in this project, they perhaps should be moved to this project for
  future use.  The script is in this folder:
  https://github.com/abcodeworks/WebShortcut-Android/tree/master/WebShortcutApp/icon

Installing
----------
Because I expect the installation instructions to change I have stored them in
a wiki page located at
https://github.com/abcodeworks/WebShortcut-PC/wiki .

Usage
-----
java -jar WebShortcutLaunch.jar "filename"

filename indicates the shortcut file to open.  The shortcut
type will be determined by the file extension.

Websites
--------
Main Website: http://beckus.github.io/WebShortcutUtil/<br/>
Source Code:  https://github.com/abcodeworks/WebShortcut-PC/<br/>
Installation wiki: https://github.com/abcodeworks/WebShortcut-PC/wiki

Building
--------
The following can be run in the common/launch folder

- To compile:<br/>
  mvn compile

- To package:<br/>
  mvn package<br/>
  The jar file is in the target/ folder
  
Libraries and Licenses
----------------------
This project is released under the Apache License 2.0.

The following libraries are used:
-   com.abcodworks.webshortcututil - Apache License 2.0

webshortcutuil includes the following libraries:
-   com.dd.plist - http://code.google.com/p/plist/ - MIT License
-   com.beetstra.jutf7 http://jutf7.sourceforge.net/ - MIT License

All licenses can be found in the root folder.
