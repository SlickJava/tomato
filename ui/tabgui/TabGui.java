/*
 * Decompiled with CFR 0_115.
 */
package cow.milkgod.cheese.ui.tabgui;

import com.darkmagician6.eventapi.EventManager;
import com.darkmagician6.eventapi.EventTarget;
import cow.milkgod.cheese.Cheese;
import cow.milkgod.cheese.events.KeyPressedEvent;
import cow.milkgod.cheese.module.Category;
import cow.milkgod.cheese.module.Module;
import cow.milkgod.cheese.module.ModuleManager;
import cow.milkgod.cheese.ttf.FontUtils;
import cow.milkgod.cheese.ui.tabgui.TabguiItem;
import cow.milkgod.cheese.utils.R2DUtils;
import cow.milkgod.cheese.utils.Wrapper;
import java.util.ArrayList;
import java.util.Objects;
import net.minecraft.client.Minecraft;

public final class TabGui
{
    private final Minecraft mc;
    private int colourBody;
    private int colourBox;
    private String colourHighlight;
    private String colourNormal;
    private String colourTitle;
    private int guiHeight;
    private boolean mainMenu;
    private int selectedItem;
    private int selectedTab;
    private int tabHeight;
    private final ArrayList<TabguiItem> tabs;
    private int transition;
    private boolean visible;
    
    public TabGui() {
        this.mc = Minecraft.getMinecraft();
        this.colourBody = -1795161088;
        this.colourBox = -1862314667;
        this.colourHighlight = "�f";
        this.colourNormal = "�7";
        this.colourTitle = "�f";
        this.guiHeight = 0;
        this.mainMenu = true;
        this.selectedItem = 0;
        this.selectedTab = 0;
        this.tabHeight = 12;
        this.tabs = new ArrayList<TabguiItem>();
        this.transition = 0;
        this.visible = true;
        Category[] values;
        for (int length = (values = Category.values()).length, i = 0; i < length; ++i) {
            final Category category = values[i];
            if (!Objects.equals(category, Category.NONE)) {
                final String otherLetters = category.name().toLowerCase().substring(1);
                final String firstLetter = category.name().substring(0, 1).toUpperCase();
                final String name = String.valueOf(String.valueOf(firstLetter)) + otherLetters;
                final TabguiItem tab = new TabguiItem(this, name);
                final ModuleManager moduleManager = Cheese.moduleManager;
                for (final Module m : ModuleManager.activeModules) {
                    if (m.getCategory().equals(category)) {
                        tab.getModules().add(new TabguiItem.GuiItem(m));
                    }
                }
                this.tabs.add(tab);
            }
        }
        this.guiHeight = this.tabs.size() * this.tabHeight;
        EventManager.register(this);
    }
    
    public void drawGui(final int x, final int y) {
        if (!this.visible) {
            return;
        }
        final int guiWidth = 60;
        R2DUtils.drawBorderedRect(x, y, x + 60 - 2, y + this.guiHeight, this.colourBody, Integer.MIN_VALUE);
        for (int i = 0; i < this.tabs.size(); ++i) {
            final int transitionTop = this.mainMenu ? (this.transition + ((Objects.equals(this.selectedTab, 0) && this.transition < 0) ? (-this.transition) : 0)) : 0;
            final int transitionBottom = this.mainMenu ? (this.transition + ((Objects.equals(this.selectedTab, this.tabs.size() - 1) && this.transition > 0) ? (-this.transition) : 0)) : 0;
            if (Objects.equals(this.selectedTab, i)) {
                R2DUtils.drawBorderedRect(x, i * 12 + y + transitionTop, x + 60 - 2, i + (y + 12 + i * 11) + transitionBottom, this.colourBox, Integer.MIN_VALUE);
            }
        }
        int yOff = y + 2;
        for (int j = 0; j < this.tabs.size(); ++j) {
            final TabguiItem tab = this.tabs.get(j);
            Wrapper.fu_default.drawStringWithShadow(String.valueOf(String.valueOf(this.colourTitle)) + tab.getTabName(), x + 2, yOff - 2, -1);
            if (Objects.equals(this.selectedTab, j) && !this.mainMenu) {
                tab.drawTabMenu(this.mc, x + 60, yOff - 2);
            }
            yOff += this.tabHeight;
        }
        if (this.transition > 0) {
            --this.transition;
        }
        else if (this.transition < 0) {
            ++this.transition;
        }
    }
    
    @EventTarget
    public void onkeyPress(final KeyPressedEvent e) {
        switch (e.getEventKey()) {
            case 200: {
                if (!this.visible) {
                    break;
                }
                if (this.mainMenu) {
                    --this.selectedTab;
                    if (this.selectedTab < 0) {
                        this.selectedTab = this.tabs.size() - 1;
                    }
                    this.transition = 3;
                    break;
                }
                --this.selectedItem;
                if (this.selectedItem < 0) {
                    this.selectedItem = this.tabs.get(this.selectedTab).getModules().size() - 1;
                }
                if (this.tabs.get(this.selectedTab).getModules().size() > 1) {
                    this.transition = 3;
                    break;
                }
                break;
            }
            case 208: {
                if (!this.visible) {
                    break;
                }
                if (this.mainMenu) {
                    ++this.selectedTab;
                    if (this.selectedTab > this.tabs.size() - 1) {
                        this.selectedTab = 0;
                    }
                    this.transition = -6;
                    break;
                }
                ++this.selectedItem;
                if (this.selectedItem > this.tabs.get(this.selectedTab).getModules().size() - 1) {
                    this.selectedItem = 0;
                }
                if (this.tabs.get(this.selectedTab).getModules().size() > 1) {
                    this.transition = -6;
                    break;
                }
                break;
            }
            case 203: {
                if (this.mainMenu) {
                    this.mainMenu = false;
                    break;
                }
                this.mainMenu = true;
                break;
            }
            case 205: {
                if (this.mainMenu) {
                    this.mainMenu = false;
                    this.selectedItem = 0;
                    break;
                }
                this.tabs.get(this.selectedTab).getModules().get(this.selectedItem).getModule().toggleModule();
                break;
            }
            case 28: {
                if (!this.mainMenu && this.visible) {
                    this.tabs.get(this.selectedTab).getModules().get(this.selectedItem).getModule().toggleModule();
                    break;
                }
                break;
            }
        }
    }
    
    public int getColourBody() {
        return this.colourBody;
    }
    
    public void setColourBody(final int colourBody) {
        this.colourBody = colourBody;
    }
    
    public int getColourBox() {
        return this.colourBox;
    }
    
    public void setColourBox(final int colourBox) {
        this.colourBox = colourBox;
    }
    
    public String getColourHightlight() {
        return this.colourHighlight;
    }
    
    public void setColourHighlight(final String colourHighlight) {
        this.colourHighlight = colourHighlight;
    }
    
    public String getColourNormal() {
        return this.colourNormal;
    }
    
    public void setColourNormal(final String colourNormal) {
        this.colourNormal = colourNormal;
    }
    
    public String getColourTitle() {
        return this.colourTitle;
    }
    
    public void setColourTitle(final String colourTitle) {
        this.colourTitle = colourTitle;
    }
    
    public int getSelectedItem() {
        return this.selectedItem;
    }
    
    public int getTabHeight() {
        return this.tabHeight;
    }
    
    public int getTransition() {
        return this.transition;
    }
}
