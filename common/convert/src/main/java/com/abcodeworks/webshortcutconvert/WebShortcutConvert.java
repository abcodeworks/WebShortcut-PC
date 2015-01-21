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

package com.abcodeworks.webshortcutconvert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.abcodeworks.webshortcututil.read.ShortcutReadUtil;

public class WebShortcutConvert {

    static void printUsage() {
        /* Print the version */
        Properties props = new Properties();
        try {
            props.load(WebShortcutConvert.class.getResourceAsStream("/META-INF/maven/com.abcodeworks/webshortcutconvert/pom.properties"));
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
    
    public static void main(String[] args) {
        if(args.length != 1) {
            printUsage();
            System.exit(-1);
        }
        
        System.exit(0);
    }

}
