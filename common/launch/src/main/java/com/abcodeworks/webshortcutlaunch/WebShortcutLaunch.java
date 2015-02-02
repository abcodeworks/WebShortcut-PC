/**
 * Copyright 2014 by Andre Beckus
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at

 *   http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.abcodeworks.webshortcutlaunch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import java.io.StringWriter;
import java.io.PrintWriter;

import com.abcodeworks.webshortcututil.read.ShortcutReadUtil;

public class WebShortcutLaunch {

    static void printUsage() {
        /* Print the version */
        Properties props = new Properties();
        try {
            props.load(WebShortcutLaunch.class.getResourceAsStream("/META-INF/maven/com.abcodeworks/webshortcutlaunch/pom.properties"));
            String version = props.getProperty("version");
            System.out.println("WebShortcutLaunch Version " + version);
            System.out.println("");
            System.out.println("Usage: java -jar WebShortcutLaunch.jar \"filename\"");
            System.out.println("filename indicates the shortcut file to open.  The shortcut");
            System.out.println("type will be determined by the file extension.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /* This method is based on:
     * http://www.mkyong.com/java/open-browser-in-java-windows-or-linux/
     */
    public static void launchBrowser(String url) throws Exception {
        String os = System.getProperty("os.name");
        String osLower = os.toLowerCase();
 
        String[] cmdarray = null;
        if (osLower.indexOf( "win" ) >= 0) {
          // Note the "\"\"" argument creates a title - this allows
          // the url to be surrounded by double quotes.
          cmdarray = new String[] {"cmd.exe", "/c", "start", "\"\"", "\"" + url + "\""};
        } else if (osLower.indexOf( "mac" ) >= 0) {
          cmdarray = new String[] {"open", url};
        } else if (osLower.indexOf( "nix") >=0 || osLower.indexOf( "nux") >=0) {
          cmdarray = new String[] {"xdg-open", url};
        // We need a handler for Solaris and aix.  There are probably others as well.
        } else {
          throw new LaunchBrowserException("Operating system not recognized: " + os);
        }
        
        try {
            Runtime rt = Runtime.getRuntime();
            rt.exec(cmdarray);
        } catch(Exception e) {
            throw new LaunchBrowserException("Error starting browser", e);
        }
    }
    
    public static void main(String[] args) {
        if(args.length != 1) {
            printUsage();
            System.exit(-1);
        }
        
        File shortcutFile = new File(args[0]);
        try {
            String url = ShortcutReadUtil.readUrlString(shortcutFile);
            launchBrowser(url);
        } catch(FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Shortcut file \"" + shortcutFile + "\" not found!");
            System.err.println("Shortcut file not found");
            System.exit(-2);
        } catch(Exception e) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            JOptionPane.showMessageDialog(null, "Error processing file \"" + shortcutFile + "\"!\n\nError:\n" + sw.toString());
            e.printStackTrace();
            System.exit(-3);
        }
        
        System.exit(0);
    }

}
