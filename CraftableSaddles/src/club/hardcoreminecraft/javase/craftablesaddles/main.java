package club.hardcoreminecraft.javase.craftablesaddles;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	/*
	 * THE WAY CRAFTING WORKS HAS CHANGED IN SPIGOT 1.3+!!!! THIS IS FOR THE NEW VERSION OF SPIGOT
	 * IF YOU NEED A LEGACY BUILD, DOWNLOAD ONE FROM THE VERSION HISTORY ON SPIGOT
	 * */
  public void onEnable() {
	  //set the event handler for the crafting permissions
    getServer().getPluginManager().registerEvents(this, (Plugin)this);
    //create the recipes
    addCustomSaddleRecipe();
    addCustomDiamondbardingRecipe();
    addCustomGoldBardingRecipe();
    addCustomIronBardingRecipe();
    addCustomNametagRecipe();
  }
  
  public void onDisable() {
    Bukkit.getServer().clearRecipes();
  }
  
  /*
   * This method checks if the player has permission and sends them a message on the craft event
   * */
  @EventHandler(priority = EventPriority.HIGH)
  public void onCraftItem(CraftItemEvent e) {
    ItemStack item = e.getCurrentItem();
    HumanEntity he = e.getWhoClicked();
    ItemStack Saddle = new ItemStack(Material.SADDLE, 1);
    ItemStack NameTag = new ItemStack(Material.NAME_TAG, 1);
    ItemStack Gha = new ItemStack(Material.GOLDEN_HORSE_ARMOR, 1);
    ItemStack Iha = new ItemStack(Material.IRON_HORSE_ARMOR, 1);
    ItemStack Dha = new ItemStack(Material.DIAMOND_HORSE_ARMOR, 1);
    if (he instanceof Player)
      if (item.equals(Saddle)) {
        Player p = (Player)he;
        if (p.hasPermission("CraftableSadles.saddle")) {
          p.sendMessage(ChatColor.GOLD + "You crafted a saddle!");
        } else {
          String Pn = e.getWhoClicked().getName();
          Player player = Bukkit.getPlayer(Pn);
          player.sendMessage(ChatColor.DARK_RED + "Sorry, you are not allowed to craft saddles.");
          e.setCancelled(true);
        } 
      } else if (item.equals(NameTag)) {
        Player p = (Player)he;
        if (p.hasPermission("CraftableSadles.NameTag")) {
          p.sendMessage(ChatColor.GOLD + "You crafted a name tag!");
        } else {
          String Pn = e.getWhoClicked().getName();
          Player player = Bukkit.getPlayer(Pn);
          player.sendMessage(ChatColor.DARK_RED + "Sorry, you are not allowed to craft name tags.");
          e.setCancelled(true);
        } 
      } else if (item.equals(Gha)) {
        Player p = (Player)he;
        if (p.hasPermission("CraftableSadles.GoldHorseArmor")) {
          p.sendMessage(ChatColor.GOLD + "You crafted golden horse armor!");
        } else {
          String Pn = e.getWhoClicked().getName();
          Player player = Bukkit.getPlayer(Pn);
          player.sendMessage(ChatColor.DARK_RED + "Sorry, you are not allowed to craft golden horse armor.");
          e.setCancelled(true);
        } 
      } else if (item.equals(Iha)) {
        Player p = (Player)he;
        if (p.hasPermission("CraftableSadles.IronHorseArmor")) {
          p.sendMessage(ChatColor.GOLD + "You crafted iron horse armor!");
        } else {
          String Pn = e.getWhoClicked().getName();
          Player player = Bukkit.getPlayer(Pn);
          player.sendMessage(ChatColor.DARK_RED + "Sorry, you are not allowed to craft iron horse armor.");
          e.setCancelled(true);
        } 
      } else if (item.equals(Dha)) {
        Player p = (Player)he;
        if (p.hasPermission("CraftableSadles.DiamondHorseArmor")) {
          p.sendMessage(ChatColor.GOLD + "You crafted diamond horse armor!");
        } else {
          String Pn = e.getWhoClicked().getName();
          Player player = Bukkit.getPlayer(Pn);
          player.sendMessage(ChatColor.DARK_RED + "Sorry, you are not allowed to craft diamond horse armor.");
          e.setCancelled(true);
        } 
      }  
  }
  
  //create the saddle
  public void addCustomSaddleRecipe() {
    ItemStack item = new ItemStack(Material.SADDLE);
    NamespacedKey item_key = new NamespacedKey((Plugin)this, "saddle_key");
    ShapedRecipe itemRecipe = new ShapedRecipe(item_key, item);
    String[] shape = { "dll", " i " };
    itemRecipe.shape(shape);
    itemRecipe.setIngredient('d', Material.DIAMOND);
    itemRecipe.setIngredient('l', Material.LEATHER);
    itemRecipe.setIngredient('i', Material.IRON_INGOT);
    Bukkit.getServer().addRecipe((Recipe)itemRecipe);
  }
  
  //create the name tag
  public void addCustomNametagRecipe() {
    ItemStack item = new ItemStack(Material.NAME_TAG);
    NamespacedKey item_key = new NamespacedKey((Plugin)this, "nametag_key");
    ShapedRecipe itemRecipe = new ShapedRecipe(item_key, item);
    String[] shape = { "  s", " p ", "i  " };
    itemRecipe.shape(shape);
    itemRecipe.setIngredient('s', Material.STRING);
    itemRecipe.setIngredient('p', Material.PAPER);
    itemRecipe.setIngredient('i', Material.IRON_INGOT);
    Bukkit.getServer().addRecipe((Recipe)itemRecipe);
  }
  
  //create the iron barding
  public void addCustomIronBardingRecipe() {
    ItemStack item = new ItemStack(Material.IRON_HORSE_ARMOR);
    NamespacedKey item_key = new NamespacedKey((Plugin)this, "iron_barding_key");
    ShapedRecipe itemRecipe = new ShapedRecipe(item_key, item);
    String[] shape = { "  i", "iwi", "iii" };
    itemRecipe.shape(shape);
    itemRecipe.setIngredient('w', Material.WHITE_WOOL);
    itemRecipe.setIngredient('i', Material.IRON_INGOT);
    Bukkit.getServer().addRecipe((Recipe)itemRecipe);
  }
  
  //create the gold barding
  public void addCustomGoldBardingRecipe() {
    ItemStack item = new ItemStack(Material.GOLDEN_HORSE_ARMOR);
    NamespacedKey item_key = new NamespacedKey((Plugin)this, "gold_barding__key");
    ShapedRecipe itemRecipe = new ShapedRecipe(item_key, item);
    String[] shape = { "  i", "iwi", "iii" };
    itemRecipe.shape(shape);
    itemRecipe.setIngredient('w', Material.WHITE_WOOL);
    itemRecipe.setIngredient('i', Material.GOLD_INGOT);
    Bukkit.getServer().addRecipe((Recipe)itemRecipe);
  }
  
  //create the diamond barding
  public void addCustomDiamondbardingRecipe() {
    ItemStack item = new ItemStack(Material.DIAMOND_HORSE_ARMOR);
    NamespacedKey item_key = new NamespacedKey((Plugin)this, "diamond_barding_key");
    ShapedRecipe itemRecipe = new ShapedRecipe(item_key, item);
    String[] shape = { "  i", "iwi", "iii" };
    itemRecipe.shape(shape);
    itemRecipe.setIngredient('w', Material.WHITE_WOOL);
    itemRecipe.setIngredient('i', Material.DIAMOND);
    Bukkit.getServer().addRecipe((Recipe)itemRecipe);
  }
}
