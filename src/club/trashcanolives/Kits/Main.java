package club.trashcanolives.Kits;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.ItemMapEmpty;
import net.minecraft.server.v1_8_R3.Items;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin implements Listener
{
    public static Inventory kits;

    public ArrayList<ItemStack> archer = new ArrayList<ItemStack>();
    public ArrayList<ItemStack> rogue = new ArrayList<ItemStack>();
    public ArrayList<ItemStack> miner = new ArrayList<ItemStack>();
    public ArrayList<ItemStack> bard = new ArrayList<ItemStack>();
    public ArrayList<ItemStack> diamond = new ArrayList<ItemStack>();


    @Override
    public void onEnable()
    {
        initKitItemStacks();
        this.getServer().getPluginManager().registerEvents(this, this);
    }


    @Override
    public void onDisable()
    {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[])
    {
        if (label.equalsIgnoreCase("kit") || label.equalsIgnoreCase("gkit") || label.equalsIgnoreCase("kits") || label.equalsIgnoreCase("gkits"))
        {
            if (!(sender instanceof Player))
            {
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "(" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "!" + ChatColor.GRAY + ChatColor.BOLD + ")" + ChatColor.RED + " Usage: /kit <player> <type> <amount> to grant the <player> <amount> uses of the <type> kit!");
                return false;
            }
            Player player = (Player) sender;
            updateKitsGUI(player);
            player.openInventory(kits);
            return true;
        }

        if (label.equalsIgnoreCase("refill") || label.equalsIgnoreCase("pots"))
        {
            if (!(sender instanceof Player))
            {
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "(" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "!" + ChatColor.GRAY + ChatColor.BOLD + ")" + ChatColor.RED + " Usage: /kit <player> <type> <amount> to grant the <player> <amount> uses of the <type> kit!");
                return false;
            }
            Player player = (Player) sender;
            Inventory refillInv = updateRefillGUI(player);
            player.openInventory(refillInv);
            return true;
        }
        return false;
    }

    private void updateKitsGUI(Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + ChatColor.UNDERLINE + "KITS");
//        //Archer, Diamond, Bard, Rogue, Mage, Miner
        String storeMessage = "" + ChatColor.RED + ChatColor.BOLD + ChatColor.ITALIC + "Purchase this kit at " + ChatColor.LIGHT_PURPLE + ChatColor.UNDERLINE + ChatColor.BOLD + ChatColor.ITALIC + "store.3d4h.world!";
        String grayDivider = "" + ChatColor.GRAY + ChatColor.STRIKETHROUGH + ChatColor.BOLD + "-------------------------------";
        String rightClickPreview = "" + ChatColor.GRAY + ChatColor.BOLD + "(" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "!" + ChatColor.GRAY + ChatColor.BOLD + ")" + ChatColor.GRAY + " right click to preview!";
        ItemStack archer = new ItemStack(Material.LEATHER_HELMET, 0);
        ItemMeta archerMeta = archer.getItemMeta();
        List<String> archerLore = new ArrayList<>();
        archerLore.add(grayDivider);
        archerLore.add("" + ChatColor.GOLD + ChatColor.BOLD + "Cooldown: " + ChatColor.RESET + ChatColor.WHITE + "24 Hours");
        archerLore.add("");
        archerLore.add(rightClickPreview);
        archerLore.add("");
        archerLore.add(storeMessage);
        archerLore.add(grayDivider);
        archerMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        archerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        archerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        archerMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Archer");
        archerMeta.setLore(archerLore);
        archer.setItemMeta(archerMeta);

        ItemStack diamond = new ItemStack(Material.DIAMOND_HELMET, 0);
        ItemMeta diamondMeta = diamond.getItemMeta();
        List<String> diamondLore = new ArrayList<>();
        diamondLore.add(grayDivider);
        diamondLore.add("" + ChatColor.AQUA + ChatColor.BOLD + "Cooldown: " + ChatColor.RESET + ChatColor.WHITE + "24 Hours");
        diamondLore.add("");
        diamondLore.add(rightClickPreview);
        diamondLore.add("");
        diamondLore.add(storeMessage);
        diamondLore.add(grayDivider);
        diamondMeta.addEnchant(Enchantment.DURABILITY, 0, true);
        diamondMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        diamondMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        diamondMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Diamond");
        diamondMeta.setLore(diamondLore);
        diamond.setItemMeta(diamondMeta);

        ItemStack bard = new ItemStack(Material.GOLD_HELMET, 0);
        ItemMeta bardMeta = bard.getItemMeta();
        List<String> bardLore = new ArrayList<>();
        bardLore.add(grayDivider);
        bardLore.add("" + ChatColor.YELLOW + ChatColor.BOLD + "Cooldown: " + ChatColor.RESET + ChatColor.WHITE + "24 Hours");
        bardLore.add("");
        bardLore.add(rightClickPreview);
        bardLore.add("");
        bardLore.add(storeMessage);
        bardLore.add(grayDivider);
        bardMeta.addEnchant(Enchantment.DURABILITY, 0, true);
        bardMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        bardMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        bardMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "Bard");
        bardMeta.setLore(bardLore);
        bard.setItemMeta(bardMeta);

        ItemStack rogue = new ItemStack(Material.CHAINMAIL_HELMET, 0);
        ItemMeta rogueMeta = rogue.getItemMeta();
        List<String> rogueLore = new ArrayList<>();
        rogueLore.add(grayDivider);
        rogueLore.add("" + ChatColor.GRAY + ChatColor.BOLD + "Cooldown: " + ChatColor.RESET + ChatColor.WHITE + "24 Hours");
        rogueLore.add("");
        rogueLore.add(rightClickPreview);
        rogueLore.add("");
        rogueLore.add(storeMessage);
        rogueLore.add(grayDivider);
        rogueMeta.addEnchant(Enchantment.DURABILITY, 0, true);
        rogueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        rogueMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        rogueMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + "Rogue");
        rogueMeta.setLore(rogueLore);
        rogue.setItemMeta(rogueMeta);

        ItemStack miner = new ItemStack(Material.IRON_HELMET, 0);
        ItemMeta minerMeta = miner.getItemMeta();
        List<String> minerLore = new ArrayList<>();
        minerLore.add(grayDivider);
        minerLore.add("" + ChatColor.WHITE + ChatColor.BOLD + "Cooldown: " + ChatColor.RESET + ChatColor.WHITE + "24 Hours");
        minerLore.add("");
        minerLore.add(rightClickPreview);
        minerLore.add("");
        minerLore.add(storeMessage);
        minerLore.add(grayDivider);
        minerMeta.addEnchant(Enchantment.DURABILITY, 1, true);
        minerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        minerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        minerMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Miner");
        minerMeta.setLore(minerLore);
        miner.setItemMeta(minerMeta);

        inv.setItem(20, archer);
        inv.setItem(21, rogue);
        inv.setItem(22, miner);
        inv.setItem(23, bard);
        inv.setItem(24, diamond);
        kits = inv;
    }

    private Inventory updateRefillGUI(Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 36, ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + ChatColor.UNDERLINE + "REFILL");

        ItemStack healpot = new ItemStack(Material.POTION, 1);
        Potion pot = new Potion(1);
        pot.setType(PotionType.INSTANT_HEAL);
        pot.setLevel(2);
        pot.setSplash(true);
        pot.apply(healpot);

        ItemStack speedpot = new ItemStack(Material.POTION, 1);
        Potion pot2 = new Potion(1);
        pot2.setType(PotionType.SPEED);
        pot2.setLevel(2);
        pot2.setSplash(false);
        pot2.apply(speedpot);

        inv.addItem(healpot, healpot, healpot, healpot, healpot, healpot, healpot, healpot, speedpot);
        inv.addItem(healpot, healpot, healpot, healpot, healpot, healpot, healpot, healpot, speedpot);
        inv.addItem(healpot, healpot, healpot, healpot, healpot, healpot, healpot, healpot, speedpot);
        inv.addItem(healpot, healpot, healpot, healpot, healpot, healpot, healpot, healpot, speedpot);

        return inv;
    }

    public void initKitItemStacks()
    {
        ItemStack healpot = new ItemStack(Material.POTION, 1);
        Potion pot = new Potion(1);
        pot.setType(PotionType.INSTANT_HEAL);
        pot.setLevel(2);
        pot.setSplash(true);
        pot.apply(healpot);

        ItemStack speedpot = new ItemStack(Material.POTION, 1);
        Potion pot2 = new Potion(1);
        pot2.setType(PotionType.SPEED);
        pot2.setLevel(2);
        pot2.setSplash(false);
        pot2.apply(speedpot);

        ItemStack sword = new ItemStack((Material.DIAMOND_SWORD), 1);
        ItemMeta swordMeta = sword.getItemMeta();
        swordMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        swordMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        sword.setItemMeta(swordMeta);

        ItemStack bow = new ItemStack(Material.BOW, 1);
        ItemMeta bowMeta = bow.getItemMeta();
        bowMeta.addEnchant(Enchantment.ARROW_DAMAGE, 4, true);
        bowMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        bowMeta.addEnchant(Enchantment.ARROW_FIRE, 1, true);
        bowMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        bow.setItemMeta(bowMeta);
        ItemStack archerHelmet = new ItemStack(Material.LEATHER_HELMET, 1);
        ItemStack archerChestPlate = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        ItemStack archerLeggings = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        ItemStack archerBoots = new ItemStack(Material.LEATHER_BOOTS, 1);
        ItemMeta archerHMeta = archerHelmet.getItemMeta();
        ItemMeta archerCMeta = archerChestPlate.getItemMeta();
        ItemMeta archerLMeta = archerLeggings.getItemMeta();
        ItemMeta archerBMeta = archerBoots.getItemMeta();
        archerHMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);archerCMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);archerLMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);archerBMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        archerHMeta.addEnchant(Enchantment.DURABILITY, 3, true);archerCMeta.addEnchant(Enchantment.DURABILITY, 3, true);archerLMeta.addEnchant(Enchantment.DURABILITY, 3, true);archerBMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        archerHelmet.setItemMeta(archerHMeta);
        archerChestPlate.setItemMeta(archerCMeta);
        archerLeggings.setItemMeta(archerLMeta);
        archerBoots.setItemMeta(archerBMeta);

        archer.add(sword);
        archer.add(new ItemStack(Material.ENDER_PEARL, 16));
        archer.add(bow);
        archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);
        archer.add(new ItemStack(Material.GOLDEN_CARROT, 64));
        archer.add(new ItemStack(Material.ARROW, 64));
        archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);
        archer.add(new ItemStack(Material.SUGAR, 64));
        archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);
        archer.add(new ItemStack(Material.FEATHER, 64));
        archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);archer.add(healpot);
        archer.add(archerHelmet);
        archer.add(archerChestPlate);
        archer.add(archerLeggings);
        archer.add(archerBoots);

        ItemStack diamondHelmet = new ItemStack(Material.DIAMOND_HELMET, 1);
        ItemStack diamondChestPlate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
        ItemStack diamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS, 1);
        ItemStack diamondBoots = new ItemStack(Material.DIAMOND_BOOTS, 1);
        ItemMeta diamondHMeta = diamondHelmet.getItemMeta();
        ItemMeta diamondCMeta = diamondChestPlate.getItemMeta();
        ItemMeta diamondLMeta = diamondLeggings.getItemMeta();
        ItemMeta diamondBMeta = diamondBoots.getItemMeta();
        diamondHMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);diamondCMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);diamondLMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);diamondBMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        diamondHMeta.addEnchant(Enchantment.DURABILITY, 3, true);diamondCMeta.addEnchant(Enchantment.DURABILITY, 3, true);diamondLMeta.addEnchant(Enchantment.DURABILITY, 3, true);diamondBMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        diamondHelmet.setItemMeta(diamondHMeta);
        diamondChestPlate.setItemMeta(diamondCMeta);
        diamondLeggings.setItemMeta(diamondLMeta);
        diamondBoots.setItemMeta(diamondBMeta);
        diamond.add(sword);
        diamond.add(new ItemStack(Material.ENDER_PEARL, 16));
        diamond.add(speedpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);
        diamond.add(new ItemStack(Material.GOLDEN_CARROT, 64));
        diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(speedpot);
        diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(speedpot);
        diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(healpot);diamond.add(speedpot);
        diamond.add(diamondHelmet);
        diamond.add(diamondChestPlate);
        diamond.add(diamondLeggings);
        diamond.add(diamondBoots);

        ItemStack bardHelmet = new ItemStack(Material.GOLD_HELMET, 1);
        ItemStack bardChestPlate = new ItemStack(Material.GOLD_CHESTPLATE, 1);
        ItemStack bardLeggings = new ItemStack(Material.GOLD_LEGGINGS, 1);
        ItemStack bardBoots = new ItemStack(Material.GOLD_BOOTS, 1);
        ItemMeta bardHMeta = bardHelmet.getItemMeta();
        ItemMeta bardCMeta = bardChestPlate.getItemMeta();
        ItemMeta bardLMeta = bardLeggings.getItemMeta();
        ItemMeta bardBMeta = bardBoots.getItemMeta();
        bardHMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);bardCMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);bardLMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);bardBMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        bardHMeta.addEnchant(Enchantment.DURABILITY, 3, true);bardCMeta.addEnchant(Enchantment.DURABILITY, 3, true);bardLMeta.addEnchant(Enchantment.DURABILITY, 3, true);bardBMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        bardHelmet.setItemMeta(bardHMeta);
        bardChestPlate.setItemMeta(bardCMeta);
        bardLeggings.setItemMeta(bardLMeta);
        bardBoots.setItemMeta(bardBMeta);
        bard.add(sword);
        bard.add(new ItemStack(Material.ENDER_PEARL, 16));
        bard.add(new ItemStack(Material.BLAZE_POWDER, 64));
        bard.add(new ItemStack(Material.GHAST_TEAR, 64));
        bard.add(new ItemStack(Material.IRON_INGOT, 64));
        bard.add(healpot); bard.add(healpot); bard.add(healpot);
        bard.add(new ItemStack(Material.GOLDEN_CARROT, 64));
        bard.add(new ItemStack(Material.INK_SACK, 64));
        bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);
        bard.add(new ItemStack(Material.SUGAR, 64));
        bard.add(new ItemStack(Material.WHEAT, 64));
        bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);
        bard.add(new ItemStack(Material.FEATHER, 64));
        bard.add(new ItemStack(Material.MAGMA_CREAM, 64));
        bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);bard.add(healpot);
        bard.add(bardHelmet);
        bard.add(bardChestPlate);
        bard.add(bardLeggings);
        bard.add(bardBoots);

        ItemStack rogueHelmet = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemStack rogueChestPlate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemStack rogueLeggings = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemStack rogueBoots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemMeta rogueHMeta = rogueHelmet.getItemMeta();
        ItemMeta rogueCMeta = rogueChestPlate.getItemMeta();
        ItemMeta rogueLMeta = rogueLeggings.getItemMeta();
        ItemMeta rogueBMeta = rogueBoots.getItemMeta();
        rogueHMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);rogueCMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);rogueLMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);rogueBMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        rogueHMeta.addEnchant(Enchantment.DURABILITY, 3, true);rogueCMeta.addEnchant(Enchantment.DURABILITY, 3, true);rogueLMeta.addEnchant(Enchantment.DURABILITY, 3, true);rogueBMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        rogueHelmet.setItemMeta(rogueHMeta);
        rogueChestPlate.setItemMeta(rogueCMeta);
        rogueLeggings.setItemMeta(rogueLMeta);
        rogueBoots.setItemMeta(rogueBMeta);
        rogue.add(sword);
        rogue.add(new ItemStack(Material.ENDER_PEARL, 16));
        rogue.add(new ItemStack(Material.GOLD_SWORD, 1));
        rogue.add(new ItemStack(Material.GOLD_SWORD, 1));
        rogue.add(healpot); rogue.add(healpot); rogue.add(healpot);
        rogue.add(new ItemStack(Material.SUGAR, 64));
        rogue.add(new ItemStack(Material.GOLDEN_CARROT, 64));
        rogue.add(new ItemStack(Material.GOLD_SWORD, 1));
        rogue.add(new ItemStack(Material.GOLD_SWORD, 1));
        rogue.add(new ItemStack(Material.GOLD_SWORD, 1));
        rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(new ItemStack(Material.FEATHER, 64));
        rogue.add(new ItemStack(Material.GOLD_SWORD, 1));rogue.add(new ItemStack(Material.GOLD_SWORD, 1));rogue.add(new ItemStack(Material.GOLD_SWORD, 1));
        rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);
        rogue.add(new ItemStack(Material.GOLD_SWORD, 1));rogue.add(new ItemStack(Material.GOLD_SWORD, 1));rogue.add(new ItemStack(Material.GOLD_SWORD, 1));
        rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);rogue.add(healpot);
        rogue.add(rogueHelmet);
        rogue.add(rogueChestPlate);
        rogue.add(rogueLeggings);
        rogue.add(rogueBoots);

        ItemStack minerHelmet = new ItemStack(Material.IRON_HELMET, 1);
        ItemStack minerChestPlate = new ItemStack(Material.IRON_CHESTPLATE, 1);
        ItemStack minerLeggings = new ItemStack(Material.IRON_LEGGINGS, 1);
        ItemStack minerBoots = new ItemStack(Material.IRON_BOOTS, 1);
        ItemMeta minerHMeta = minerHelmet.getItemMeta();
        ItemMeta minerCMeta = minerChestPlate.getItemMeta();
        ItemMeta minerLMeta = minerLeggings.getItemMeta();
        ItemMeta minerBMeta = minerBoots.getItemMeta();
        minerHMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);minerCMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);minerLMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);minerBMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        minerHMeta.addEnchant(Enchantment.DURABILITY, 3, true);minerCMeta.addEnchant(Enchantment.DURABILITY, 3, true);minerLMeta.addEnchant(Enchantment.DURABILITY, 3, true);minerBMeta.addEnchant(Enchantment.DURABILITY, 3, true);minerBMeta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
        minerHelmet.setItemMeta(minerHMeta);
        minerChestPlate.setItemMeta(minerCMeta);
        minerLeggings.setItemMeta(minerLMeta);
        minerBoots.setItemMeta(minerBMeta);

        ItemStack pick = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta pickMeta = pick.getItemMeta();pickMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);pickMeta.addEnchant(Enchantment.SILK_TOUCH, 1, true);pickMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        pick.setItemMeta(pickMeta);

        ItemStack pick2 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta pick2Meta = pick2.getItemMeta();pick2Meta.addEnchant(Enchantment.DIG_SPEED, 5, true);pick2Meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);pick2Meta.addEnchant(Enchantment.DURABILITY, 3, true);
        pick2.setItemMeta(pick2Meta);

        ItemStack axe = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta axeMeta = axe.getItemMeta();axeMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);axeMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        axe.setItemMeta(axeMeta);

        ItemStack shovel = new ItemStack(Material.DIAMOND_AXE, 1);
        ItemMeta shovelMeta = shovel.getItemMeta();shovelMeta.addEnchant(Enchantment.DIG_SPEED, 5, true);shovelMeta.addEnchant(Enchantment.DURABILITY, 3, true);
        shovel.setItemMeta(shovelMeta);

        miner.add(shovel);
        miner.add(new ItemStack(Material.ENDER_PEARL, 64));
        miner.add(pick);miner.add(pick2);miner.add(axe);
        miner.add(new ItemStack(Material.WATER_BUCKET, 1));
        miner.add(new ItemStack(Material.LAVA_BUCKET, 1));
        miner.add(new ItemStack(Material.WATER_BUCKET, 1));
        miner.add(new ItemStack(Material.LOG, 64));
        miner.add(new ItemStack(Material.TRAPPED_CHEST, 64));
        miner.add(new ItemStack(Material.CHEST, 64));
        miner.add(new ItemStack(Material.ANVIL, 64));
        miner.add(new ItemStack(Material.LEVER, 64));
        miner.add(new ItemStack(Material.WOOD_BUTTON, 64));
        miner.add(new ItemStack(Material.HOPPER, 64));
        miner.add(new ItemStack(Material.TRAPPED_CHEST, 64));
        miner.add(new ItemStack(Material.DROPPER, 64));
        miner.add(new ItemStack(Material.PISTON_BASE, 64));
        miner.add(new ItemStack(Material.PISTON_STICKY_BASE, 64));
        miner.add(new ItemStack(Material.TRAPPED_CHEST, 64));
        miner.add(new ItemStack(Material.GRASS, 64));
        miner.add(new ItemStack(Material.GRASS, 64));
        miner.add(new ItemStack(Material.STONE, 64));
        miner.add(new ItemStack(Material.FENCE_GATE, 64));
        miner.add(new ItemStack(Material.FENCE_GATE, 64));
        miner.add(new ItemStack(Material.REDSTONE_WIRE, 32));
        miner.add(new ItemStack(Material.REDSTONE_WIRE, 32));
        miner.add(new ItemStack(Material.DIODE, 64));
        miner.add(new ItemStack(Material.REDSTONE_COMPARATOR, 64));
        miner.add(new ItemStack(Material.STONE, 64));
        miner.add(new ItemStack(Material.STONE, 64));
        miner.add(new ItemStack(Material.GLASS, 64));
        miner.add(new ItemStack(Material.GLASS, 64));
        miner.add(new ItemStack(Material.SAND, 64));
        miner.add(new ItemStack(Material.SAND, 64));
        miner.add(new ItemStack(Material.FURNACE, 64));
        miner.add(new ItemStack(Material.LOG, 64));
        miner.add(new ItemStack(Material.WORKBENCH, 64));
        miner.add(minerHelmet);
        miner.add(minerChestPlate);
        miner.add(minerLeggings);
        miner.add(minerBoots);
    }
    @EventHandler
    public void onClick(InventoryClickEvent event)
    {

        if (event.getView().getTitle().contains("KITS"))
        {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            if (event.getSlot() == 20)
            {
                if (event.getClick().isLeftClick())
                {
                    giveKit(player, archer, "" + ChatColor.GOLD + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Archer", true);
                    player.closeInventory();

                } else if (event.getClick().isRightClick())
                {
                    previewKit(player, archer, "" + ChatColor.GOLD + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Archer");
                } else if (event.getClick().isShiftClick())
                {
                    giveKit(player, archer, "" + ChatColor.GOLD + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Archer", true);
                }
            }

            if (event.getSlot() == 21)
            {
                if (event.getClick().isLeftClick())
                {
                    giveKit(player, rogue, "" + ChatColor.GRAY + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Rogue", true);
                    player.closeInventory();
                } else if (event.getClick().isRightClick())
                {
                    previewKit(player, rogue, "" + ChatColor.GRAY + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Rogue");
                }
            }

            if (event.getSlot() == 22)
            {
                if (event.getClick().isLeftClick())
                {
                    giveKit(player, miner, "" + ChatColor.WHITE + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Miner", true);
                    player.closeInventory();
                } else if (event.getClick().isRightClick())
                {
                    previewKit(player, miner, "" + ChatColor.WHITE + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Miner");
                }
            }

            if (event.getSlot() == 23)
            {
                if (event.getClick().isLeftClick())
                {
                    giveKit(player, bard, "" + ChatColor.YELLOW + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Bard", true);
                    player.closeInventory();
                } else if (event.getClick().isRightClick())
                {
                    previewKit(player, bard, "" + ChatColor.YELLOW + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Bard");
                }
            }

            if (event.getSlot() == 24)
            {
                if (event.getClick().isLeftClick())
                {
                    giveKit(player, diamond, "" + ChatColor.AQUA + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Diamond", true);
                    player.closeInventory();
                } else if (event.getClick().isRightClick())
                {
                    previewKit(player, diamond, "" + ChatColor.AQUA + ChatColor.BOLD + ChatColor.ITALIC + ChatColor.UNDERLINE + "Diamond");
                }
            }
        }
        if (event.getView().getTitle().contains("Kit"))
        {
            event.setCancelled(true);
        }
        return;
    }

    public void previewKit(Player player, ArrayList<ItemStack> items, String name)
    {
        Inventory inv = Bukkit.createInventory(null, 45, "" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + ChatColor.UNDERLINE + name + " Kit");
        for (int i = 0; i < items.size(); i++)
        {
            inv.addItem(items.get(i));
        }
        ItemStack table = new ItemStack(Material.WORKBENCH);
        ItemMeta tableMeta = table.getItemMeta();
        ArrayList<String> lore = new ArrayList<>();
        lore.add("" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Kit: " + name);
        tableMeta.setDisplayName("" + ChatColor.BOLD);
        tableMeta.setLore(lore);
        table.setItemMeta(tableMeta);
        inv.addItem(table);
        player.openInventory(inv);
    }

    public void giveKit(Player player, ArrayList<ItemStack> items, String name, boolean classKit)
    {
        if (classKit)
        {
            int j = items.size()-4;
            for (int i = 0; i < items.size()-4; i++)
            {
                if (player.getInventory().firstEmpty() == -1)
                {
                    player.getWorld().dropItem(player.getLocation(), items.get(i));
                } else
                {
                    player.getInventory().addItem(items.get(i));
                }
            }
            if (player.getInventory().getHelmet() == null)
            {
                player.getInventory().setHelmet(items.get(j++));
            } else
            {
                player.getWorld().dropItem(player.getLocation(), items.get(j++));
            }

            if (player.getInventory().getChestplate() == null)
            {
                player.getInventory().setChestplate(items.get(j++));
            } else
            {
                player.getWorld().dropItem(player.getLocation(), items.get(j++));
            }
            if (player.getInventory().getLeggings() == null)
            {
                player.getInventory().setLeggings(items.get(j++));
            } else
            {
                player.getWorld().dropItem(player.getLocation(), items.get(j++));
            }
            if (player.getInventory().getBoots() == null)
            {
                player.getInventory().setBoots(items.get(j++));
            } else
            {
                player.getWorld().dropItem(player.getLocation(), items.get(j++));
            }
        } else
        {

        }

        TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8&l(&d&l!&8&l) &d&l&o" + player.getDisplayName() + "&f redeemed their " + name + " Kit!"));
        message.setClickEvent( new ClickEvent( ClickEvent.Action.OPEN_URL, "https://store.3d4h.world" ) );
        message.setHoverEvent( new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder( "" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD + "Visit our store! (store.3d4h.world)" ).create()) );
        this.getServer().spigot().broadcast(message);
    }

}
