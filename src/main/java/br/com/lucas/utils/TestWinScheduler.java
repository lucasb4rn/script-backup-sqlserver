package br.com.lucas.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestWinScheduler {

public static void main(String args[]) throws IOException, InterruptedException {
  // schtasks /create /tn "HowToTask" /tr c:\temp\test.cmd /sc once /st 00:00:00 /sd 2022/01/01 /ru username /rp password

  List<String> commands = new ArrayList<String>();

  commands.add("schtasks.exe");
  commands.add("/CREATE");
  commands.add("/TN");
  commands.add("\"HowToTask\"");
  commands.add("/TR");
  commands.add("\"c:/temp/test.cmd\"");
  commands.add("/SC");
  commands.add("once");
  commands.add("/ST");
  commands.add("00:00:00");
  commands.add("/SD");
  commands.add("2022/10/10");
/*  commands.add("/RU");
  commands.add("username");
  commands.add("/RP");
  commands.add("password");*/

  ProcessBuilder builder = new ProcessBuilder(commands);
  Process p = builder.start();
  p.waitFor();
  System.out.println(p.exitValue()); // 0 : OK
                                     // 1 : Error
  }
}