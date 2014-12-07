ShareWebShortcut (Java Application)
==============================

Summary
-------
Java library for reading and writing web shortcut files

Websites
--------
Main Website: http://beckus.github.io/WebShortcutUtil/<br/>
Source Code:  https://github.com/abcodeworks/ShareWebShortcut-Java/<br/>

Building
--------
- To compile:<br/>
  mvn compile

- To package:<br/>
mvn install:install-file -Dfile=lib/BrowserLauncher2-1_3.jar -DgroupId=edu.stanford.ejalbert \
    -DartifactId=BrowserLauncher2 -Dversion=1.3 -Dpackaging=jar

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
