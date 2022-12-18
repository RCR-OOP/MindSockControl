package tending.minsockcontrol;

import java.lang.*;
import arc.util.*;
import mindustry.gen.*;
import mindustry.mod.*;
import java.net.*;
import java.io.*;

import static mindustry.Vars.*;

public class Client implements Runnable
{
    public Socket sock;
    public PrintWriter out;
    public BufferedReader in;

    public static String removePrefix(String s, String prefix)
    {
        if (s != null && s.startsWith(prefix)) {
            return s.split(prefix, 2)[1];
        }
        return s;
    }

    public void log(String a)
    {
        Log.info("[MinSockControl]["+sock+"]: "+a);
    }

    public void run()
    {
        log("Ready!");
        try {
            while (true)
            {
                String proglang = in.readLine();
                log("Client uses "+proglang+" programming language");
                String i = in.readLine();
                if (i.startsWith("JS "))
                {
                    String output = mods.getScripts().runConsole(removePrefix(i, "JS "));
                    out.println("" + output));
                }
            }
        }
        catch (Exception e)
        {
            log("Err: "+e);
        }
    }
    private boolean isError(String output) {
        try {
            String errorName = output.substring(0, output.indexOf(' ') - 1);
            Class.forName("org.mozilla.javascript." + errorName);
            return true;
        } catch (Throwable e) {
            return false;
        }
    }
}