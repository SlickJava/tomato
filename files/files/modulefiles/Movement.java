/*
 * Decompiled with CFR 0_115.
 */
package cow.milkgod.cheese.files.files.modulefiles;

import com.google.common.base.Objects;
import cow.milkgod.cheese.files.FileManager;
import cow.milkgod.cheese.module.Category;
import cow.milkgod.cheese.module.Module;
import cow.milkgod.cheese.properties.Property;
import cow.milkgod.cheese.properties.PropertyManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

public class Movement
extends FileManager.CustomFile {
    public Movement(String name, boolean Module2, boolean loadOnStart) {
        super(name, Module2, loadOnStart);
    }

    @Override
    public void loadFile() throws IOException {
        String line;
        BufferedReader variable9 = new BufferedReader(new FileReader(this.getFile()));
        while ((line = variable9.readLine()) != null) {
            int i2 = line.indexOf(":");
            if (i2 < 0) continue;
            String settingnameLine = line.substring(0, i2).trim();
            String value = line.substring(i2 + 1).trim();
            for (Property p2 : PropertyManager.properties) {
                if (p2.getModule() == null || !Objects.equal((Object)p2.getModule().getCategory(), (Object)Category.MOVEMENT)) continue;
                try {
                    String settingname = settingnameLine.substring(p2.getModule().getName().length() + 1).trim();
                    if (!p2.getName().equalsIgnoreCase(settingname)) continue;
                    this.setValue(p2, value);
                    continue;
                }
                catch (Exception settingname) {
                    // empty catch block
                }
            }
        }
        System.out.println("Loaded " + this.getName() + " File!");
        variable9.close();
    }

    @Override
    public void saveFile() throws IOException {
        PrintWriter variable9 = new PrintWriter(new FileWriter(this.getFile()));
        for (Property p2 : PropertyManager.properties) {
            if (p2.getModule() == null) {
                variable9.close();
                return;
            }
            if (p2.getModule().getCategory() != Category.MOVEMENT) continue;
            variable9.println(String.valueOf(String.valueOf(p2.getModule().getName())) + "-" + p2.getName() + ":" + p2.value);
        }
        variable9.close();
    }
}

