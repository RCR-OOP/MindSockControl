/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package tending.minsockcontrol;

import arc.util.*;
import mindustry.gen.*;
import mindustry.mod.*;
import java.lang.*;

import static mindustry.Vars.*;

import tending.minsockcontrol.*;

public class Library extends Plugin {
    @Override
    public void init() {
        Log.info("[MinSockControl]: Starting...");
        Main obj = new Main();
        Thread thread = new Thread(obj);
        thread.start();
    }
}
