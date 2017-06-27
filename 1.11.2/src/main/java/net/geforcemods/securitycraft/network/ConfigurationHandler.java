package net.geforcemods.securitycraft.network;

import net.geforcemods.securitycraft.api.CustomizableSCTE;
import net.geforcemods.securitycraft.api.TileEntitySCTE;
import net.geforcemods.securitycraft.blocks.BlockAlarm;
import net.geforcemods.securitycraft.blocks.BlockCageTrap;
import net.geforcemods.securitycraft.blocks.BlockFakeLava;
import net.geforcemods.securitycraft.blocks.BlockFakeLavaBase;
import net.geforcemods.securitycraft.blocks.BlockFakeWater;
import net.geforcemods.securitycraft.blocks.BlockFakeWaterBase;
import net.geforcemods.securitycraft.blocks.BlockFrame;
import net.geforcemods.securitycraft.blocks.BlockInventoryScanner;
import net.geforcemods.securitycraft.blocks.BlockInventoryScannerField;
import net.geforcemods.securitycraft.blocks.BlockIronFence;
import net.geforcemods.securitycraft.blocks.BlockIronTrapDoor;
import net.geforcemods.securitycraft.blocks.BlockKeycardReader;
import net.geforcemods.securitycraft.blocks.BlockKeypad;
import net.geforcemods.securitycraft.blocks.BlockKeypadChest;
import net.geforcemods.securitycraft.blocks.BlockKeypadFurnace;
import net.geforcemods.securitycraft.blocks.BlockLaserBlock;
import net.geforcemods.securitycraft.blocks.BlockLaserField;
import net.geforcemods.securitycraft.blocks.BlockLogger;
import net.geforcemods.securitycraft.blocks.BlockOwnable;
import net.geforcemods.securitycraft.blocks.BlockPanicButton;
import net.geforcemods.securitycraft.blocks.BlockPortableRadar;
import net.geforcemods.securitycraft.blocks.BlockProtecto;
import net.geforcemods.securitycraft.blocks.BlockReinforcedDoor;
import net.geforcemods.securitycraft.blocks.BlockReinforcedFenceGate;
import net.geforcemods.securitycraft.blocks.BlockReinforcedGlass;
import net.geforcemods.securitycraft.blocks.BlockReinforcedIronBars;
import net.geforcemods.securitycraft.blocks.BlockReinforcedSandstone;
import net.geforcemods.securitycraft.blocks.BlockReinforcedSlabs;
import net.geforcemods.securitycraft.blocks.BlockReinforcedStainedGlass;
import net.geforcemods.securitycraft.blocks.BlockReinforcedStairs;
import net.geforcemods.securitycraft.blocks.BlockReinforcedWood;
import net.geforcemods.securitycraft.blocks.BlockReinforcedWoodSlabs;
import net.geforcemods.securitycraft.blocks.BlockRetinalScanner;
import net.geforcemods.securitycraft.blocks.BlockScannerDoor;
import net.geforcemods.securitycraft.blocks.BlockSecurityCamera;
import net.geforcemods.securitycraft.blocks.mines.BlockBouncingBetty;
import net.geforcemods.securitycraft.blocks.mines.BlockClaymore;
import net.geforcemods.securitycraft.blocks.mines.BlockFullMineBase;
import net.geforcemods.securitycraft.blocks.mines.BlockFurnaceMine;
import net.geforcemods.securitycraft.blocks.mines.BlockIMS;
import net.geforcemods.securitycraft.blocks.mines.BlockMine;
import net.geforcemods.securitycraft.blocks.mines.BlockTrackMine;
import net.geforcemods.securitycraft.entity.EntityBouncingBetty;
import net.geforcemods.securitycraft.entity.EntityIMSBomb;
import net.geforcemods.securitycraft.entity.EntitySecurityCamera;
import net.geforcemods.securitycraft.entity.EntityTaserBullet;
import net.geforcemods.securitycraft.gui.GuiHandler;
import net.geforcemods.securitycraft.items.ItemAdminTool;
import net.geforcemods.securitycraft.items.ItemBlockReinforcedPlanks;
import net.geforcemods.securitycraft.items.ItemBlockReinforcedSandstone;
import net.geforcemods.securitycraft.items.ItemBlockReinforcedSlabs;
import net.geforcemods.securitycraft.items.ItemBlockReinforcedStainedGlass;
import net.geforcemods.securitycraft.items.ItemBlockReinforcedWoodSlabs;
import net.geforcemods.securitycraft.items.ItemBriefcase;
import net.geforcemods.securitycraft.items.ItemCameraMonitor;
import net.geforcemods.securitycraft.items.ItemCodebreaker;
import net.geforcemods.securitycraft.items.ItemKeyPanel;
import net.geforcemods.securitycraft.items.ItemKeycardBase;
import net.geforcemods.securitycraft.items.ItemMineRemoteAccessTool;
import net.geforcemods.securitycraft.items.ItemModifiedBucket;
import net.geforcemods.securitycraft.items.ItemModule;
import net.geforcemods.securitycraft.items.ItemReinforcedDoor;
import net.geforcemods.securitycraft.items.ItemSCManual;
import net.geforcemods.securitycraft.items.ItemScannerDoor;
import net.geforcemods.securitycraft.items.ItemTaser;
import net.geforcemods.securitycraft.items.ItemUniversalBlockModifier;
import net.geforcemods.securitycraft.items.ItemUniversalBlockReinforcer;
import net.geforcemods.securitycraft.items.ItemUniversalBlockRemover;
import net.geforcemods.securitycraft.items.ItemUniversalKeyChanger;
import net.geforcemods.securitycraft.items.ItemUniversalOwnerChanger;
import net.geforcemods.securitycraft.main.mod_SecurityCraft;
import net.geforcemods.securitycraft.misc.EnumCustomModules;
import net.geforcemods.securitycraft.misc.SCManualPage;
import net.geforcemods.securitycraft.misc.SCSounds;
import net.geforcemods.securitycraft.network.packets.PacketCPlaySoundAtPos;
import net.geforcemods.securitycraft.network.packets.PacketCRequestTEOwnableUpdate;
import net.geforcemods.securitycraft.network.packets.PacketCSetPlayerPositionAndRotation;
import net.geforcemods.securitycraft.network.packets.PacketCUpdateNBTTag;
import net.geforcemods.securitycraft.network.packets.PacketGivePotionEffect;
import net.geforcemods.securitycraft.network.packets.PacketSAddModules;
import net.geforcemods.securitycraft.network.packets.PacketSCheckPassword;
import net.geforcemods.securitycraft.network.packets.PacketSMountCamera;
import net.geforcemods.securitycraft.network.packets.PacketSOpenGui;
import net.geforcemods.securitycraft.network.packets.PacketSSetCameraRotation;
import net.geforcemods.securitycraft.network.packets.PacketSSetOwner;
import net.geforcemods.securitycraft.network.packets.PacketSSetPassword;
import net.geforcemods.securitycraft.network.packets.PacketSSyncTENBTTag;
import net.geforcemods.securitycraft.network.packets.PacketSToggleOption;
import net.geforcemods.securitycraft.network.packets.PacketSUpdateNBTTag;
import net.geforcemods.securitycraft.network.packets.PacketSUpdateTEOwnable;
import net.geforcemods.securitycraft.network.packets.PacketSetBlock;
import net.geforcemods.securitycraft.network.packets.PacketSetExplosiveState;
import net.geforcemods.securitycraft.network.packets.PacketSetISType;
import net.geforcemods.securitycraft.network.packets.PacketSetKeycardLevel;
import net.geforcemods.securitycraft.network.packets.PacketUpdateLogger;
import net.geforcemods.securitycraft.tileentity.TileEntityAlarm;
import net.geforcemods.securitycraft.tileentity.TileEntityCageTrap;
import net.geforcemods.securitycraft.tileentity.TileEntityClaymore;
import net.geforcemods.securitycraft.tileentity.TileEntityIMS;
import net.geforcemods.securitycraft.tileentity.TileEntityInventoryScanner;
import net.geforcemods.securitycraft.tileentity.TileEntityKeycardReader;
import net.geforcemods.securitycraft.tileentity.TileEntityKeypad;
import net.geforcemods.securitycraft.tileentity.TileEntityKeypadChest;
import net.geforcemods.securitycraft.tileentity.TileEntityKeypadFurnace;
import net.geforcemods.securitycraft.tileentity.TileEntityLaserBlock;
import net.geforcemods.securitycraft.tileentity.TileEntityLogger;
import net.geforcemods.securitycraft.tileentity.TileEntityOwnable;
import net.geforcemods.securitycraft.tileentity.TileEntityPortableRadar;
import net.geforcemods.securitycraft.tileentity.TileEntityProtecto;
import net.geforcemods.securitycraft.tileentity.TileEntityRetinalScanner;
import net.geforcemods.securitycraft.tileentity.TileEntityScannerDoor;
import net.geforcemods.securitycraft.tileentity.TileEntitySecurityCamera;
import net.geforcemods.securitycraft.util.ClientUtils;
import net.geforcemods.securitycraft.util.ItemUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ConfigurationHandler{
	private int[]  harmingPotions = {8268, 8236, 16460, 16428};
	private int[]  healingPotions = {8261, 8229, 16453, 16421};
	
	//******************configuration options
	public boolean allowCodebreakerItem;
	public boolean allowAdminTool;
	public boolean shouldSpawnFire;
	public boolean ableToBreakMines;
	public boolean ableToCraftKeycard1;
	public boolean ableToCraftKeycard2;
	public boolean ableToCraftKeycard3;
	public boolean ableToCraftKeycard4;
	public boolean ableToCraftKeycard5;
	public boolean ableToCraftLUKeycard;
	public boolean smallerMineExplosion;
	public boolean mineExplodesWhenInCreative;
	public boolean sayThanksMessage;
	public boolean isIrcBotEnabled;
	public boolean disconnectOnWorldClose;
	public boolean useOldKeypadRecipe;
	public boolean checkForUpdates;
	public double portableRadarSearchRadius;
	public int usernameLoggerSearchRadius;	
    public int laserBlockRange;
	public int alarmTickDelay;
	public double alarmSoundVolume;
	public int cageTrapTextureIndex;
	public int empRadius;
	public int portableRadarDelay;
	public int claymoreRange;
	public int imsRange;
	public float cameraSpeed;
	//***************************************

	public void setupAdditions(){
		this.setupTechnicalBlocks();
		this.setupMines();
		this.setupItems();
	}
	
	public void setupDebugAdditions(){
		this.setupDebuggingBlocks();
	}

	public void setupTechnicalBlocks(){
		mod_SecurityCraft.laserBlock = new BlockLaserBlock(Material.IRON).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("laser_block").setUnlocalizedName("laserBlock");
		mod_SecurityCraft.laser = new BlockLaserField(Material.ROCK).setBlockUnbreakable().setResistance(1000F).setRegistryName("laser");
		
		mod_SecurityCraft.keypad = new BlockKeypad(Material.IRON).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("keypad").setUnlocalizedName("keypad");
						
		mod_SecurityCraft.retinalScanner = new BlockRetinalScanner(Material.IRON).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("retinal_scanner").setUnlocalizedName("retinalScanner");
	    
		mod_SecurityCraft.reinforcedDoor = new BlockReinforcedDoor(Material.IRON).setBlockUnbreakable().setResistance(1000F).setRegistryName("iron_door_reinforced").setUnlocalizedName("ironDoorReinforced");
		
		mod_SecurityCraft.bogusLava = (BlockStaticLiquid) new BlockFakeLavaBase(Material.LAVA).setHardness(100.0F).setLightLevel(1.0F).setRegistryName("bogus_lava").setUnlocalizedName("bogusLava");
		mod_SecurityCraft.bogusLavaFlowing = new BlockFakeLava(Material.LAVA).setHardness(0.0F).setLightLevel(1.0F).setRegistryName("bogus_lava_flowing").setUnlocalizedName("bogusLavaFlowing");
		mod_SecurityCraft.bogusWater = (BlockStaticLiquid) new BlockFakeWaterBase(Material.WATER).setHardness(100.0F).setRegistryName("bogus_water").setUnlocalizedName("bogusWater");
		mod_SecurityCraft.bogusWaterFlowing = new BlockFakeWater(Material.WATER).setHardness(0.0F).setRegistryName("bogus_water_flowing").setUnlocalizedName("bogusWaterFlowing");
		
		mod_SecurityCraft.keycardReader = new BlockKeycardReader(Material.IRON).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("keycard_reader").setUnlocalizedName("keycardReader");
	    
		mod_SecurityCraft.ironTrapdoor = new BlockIronTrapDoor(Material.IRON).setHardness(5.0F).setResistance(200F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_iron_trapdoor").setUnlocalizedName("reinforcedIronTrapdoor");

		mod_SecurityCraft.inventoryScanner = new BlockInventoryScanner(Material.ROCK).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("inventory_scanner").setUnlocalizedName("inventoryScanner");
		mod_SecurityCraft.inventoryScannerField = new BlockInventoryScannerField(Material.GLASS).setBlockUnbreakable().setResistance(1000F).setRegistryName("inventory_scanner_field").setUnlocalizedName("inventoryScannerField");
				
	    mod_SecurityCraft.cageTrap = new BlockCageTrap(Material.ROCK).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("cage_trap").setUnlocalizedName("cageTrap");
		
	    mod_SecurityCraft.portableRadar = new BlockPortableRadar(Material.CIRCUITS).setHardness(1F).setResistance(50F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("portable_radar").setUnlocalizedName("portableRadar");
	    
	    mod_SecurityCraft.unbreakableIronBars = new BlockReinforcedIronBars(Material.IRON, true).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setBlockUnbreakable().setResistance(1000F).setRegistryName("reinforced_iron_bars").setUnlocalizedName("reinforcedIronBars");
	    
		mod_SecurityCraft.keypadChest = new BlockKeypadChest().setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("keypad_chest").setUnlocalizedName("keypadChest");
	
	    mod_SecurityCraft.usernameLogger = new BlockLogger(Material.ROCK).setHardness(8F).setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("username_logger").setUnlocalizedName("usernameLogger");
	
		mod_SecurityCraft.alarm = new BlockAlarm(Material.IRON, false).setBlockUnbreakable().setResistance(1000F).setTickRandomly(true).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("alarm").setUnlocalizedName("alarm");
		mod_SecurityCraft.alarmLit = new BlockAlarm(Material.IRON, true).setBlockUnbreakable().setResistance(1000F).setTickRandomly(true).setRegistryName("alarm_lit").setUnlocalizedName("alarmLit");

		mod_SecurityCraft.reinforcedStone = new BlockOwnable(Material.ROCK, EnumBlockRenderType.MODEL).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stone").setUnlocalizedName("reinforcedStone");
	
		mod_SecurityCraft.reinforcedFencegate = new BlockReinforcedFenceGate().setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_fence_gate").setUnlocalizedName("reinforcedFenceGate");
		
		mod_SecurityCraft.reinforcedWoodPlanks = new BlockReinforcedWood().setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_planks").setUnlocalizedName("reinforcedPlanks");
	
		mod_SecurityCraft.panicButton = new BlockPanicButton().setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("panic_button").setUnlocalizedName("panicButton");
	
		mod_SecurityCraft.frame = new BlockFrame(Material.ROCK).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("keypad_frame").setUnlocalizedName("keypadFrame");
	
		mod_SecurityCraft.keypadFurnace = new BlockKeypadFurnace(Material.IRON).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("keypad_gurnace").setUnlocalizedName("keypadFurnace");
	
	    mod_SecurityCraft.securityCamera = new BlockSecurityCamera(Material.IRON).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("security_camera").setUnlocalizedName("securityCamera");
	
	    mod_SecurityCraft.reinforcedStairsOak = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedWoodPlanks, 0).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_oak").setUnlocalizedName("reinforcedStairsOak");
	    mod_SecurityCraft.reinforcedStairsSpruce = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedWoodPlanks, 1).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_spruce").setUnlocalizedName("reinforcedStairsSpruce");
	    mod_SecurityCraft.reinforcedStairsBirch = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedWoodPlanks, 2).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_birch").setUnlocalizedName("reinforcedStairsBirch");
	    mod_SecurityCraft.reinforcedStairsJungle = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedWoodPlanks, 3).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_jungle").setUnlocalizedName("reinforcedStairsJungle");
	    mod_SecurityCraft.reinforcedStairsAcacia = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedWoodPlanks, 4).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_acacia").setUnlocalizedName("reinforcedStairsAcacia");
	    mod_SecurityCraft.reinforcedStairsDarkoak = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedWoodPlanks, 5).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_darkoak").setUnlocalizedName("reinforcedStairsDarkoak");
	    mod_SecurityCraft.reinforcedStairsStone = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedStone, 0).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_stone").setUnlocalizedName("reinforcedStairsStone");

	    mod_SecurityCraft.ironFence = new BlockIronFence(Material.IRON).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("electrified_iron_fence").setUnlocalizedName("electrifiedIronFence");
	
	    mod_SecurityCraft.reinforcedGlass = new BlockReinforcedGlass(Material.GLASS).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_glass_block").setUnlocalizedName("reinforcedGlassBlock");
	    mod_SecurityCraft.reinforcedStainedGlass = new BlockReinforcedStainedGlass(Material.GLASS).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stained_glass").setUnlocalizedName("reinforcedStainedGlass");
	    
	    mod_SecurityCraft.reinforcedDirt = new BlockOwnable(Material.GROUND, EnumBlockRenderType.MODEL).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_dirt").setUnlocalizedName("reinforcedDirt");
		
		mod_SecurityCraft.reinforcedCobblestone = new BlockOwnable(Material.ROCK, EnumBlockRenderType.MODEL).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_cobblestone").setUnlocalizedName("reinforcedCobblestone");
	    mod_SecurityCraft.reinforcedStairsCobblestone = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedCobblestone, 0).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_cobblestone").setUnlocalizedName("reinforcedStairsCobblestone");

	    mod_SecurityCraft.reinforcedSandstone = new BlockReinforcedSandstone().setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_sandstone").setUnlocalizedName("reinforcedSandstone");
	    mod_SecurityCraft.reinforcedStairsSandstone = new BlockReinforcedStairs(mod_SecurityCraft.reinforcedSandstone, 0).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stairs_sandstone").setUnlocalizedName("reinforcedStairsSandstone");

	    mod_SecurityCraft.reinforcedWoodSlabs = new BlockReinforcedWoodSlabs(false).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_wood_slabs").setUnlocalizedName("reinforcedWoodSlabs");
	    mod_SecurityCraft.reinforcedDoubleWoodSlabs = new BlockReinforcedWoodSlabs(true).setBlockUnbreakable().setResistance(1000).setRegistryName("reinforced_double_wood_slabs").setUnlocalizedName("reinforcedDoubleWoodSlabs");
	    mod_SecurityCraft.reinforcedStoneSlabs = new BlockReinforcedSlabs(false, Material.ROCK).setBlockUnbreakable().setResistance(1000).setCreativeTab(mod_SecurityCraft.tabSCDecoration).setRegistryName("reinforced_stone_slabs").setUnlocalizedName("reinforcedStoneSlabs");
	    mod_SecurityCraft.reinforcedDoubleStoneSlabs = new BlockReinforcedSlabs(true, Material.ROCK).setBlockUnbreakable().setResistance(1000).setRegistryName("reinforced_double_stone_slabs").setUnlocalizedName("reinforcedDoubleStoneSlabs");
	  
	
		mod_SecurityCraft.protecto = new BlockProtecto(Material.IRON).setBlockUnbreakable().setResistance(1000F).setLightLevel(0.5F).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("protecto").setUnlocalizedName("protecto");
	
		mod_SecurityCraft.scannerDoor = new BlockScannerDoor(Material.IRON).setBlockUnbreakable().setResistance(1000F).setRegistryName("scanner_door").setUnlocalizedName("scannerDoor");
	}
	
	public void setupMines(){
		mod_SecurityCraft.mine = (BlockMine) new BlockMine(Material.CIRCUITS).setHardness(!ableToBreakMines ? -1F : 1F).setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCMine).setRegistryName("mine").setUnlocalizedName("mine");
		mod_SecurityCraft.mineCut = (BlockMine) new BlockMine(Material.CIRCUITS).setHardness(!ableToBreakMines ? -1F : 1F).setResistance(1000F).setRegistryName("mine_cut").setUnlocalizedName("mineCut");
		
		mod_SecurityCraft.dirtMine = new BlockFullMineBase(Material.GROUND, Blocks.DIRT).setCreativeTab(mod_SecurityCraft.tabSCMine).setHardness(!ableToBreakMines ? -1F : 1.25F).setRegistryName("dirt_mine").setUnlocalizedName("dirtMine");
		mod_SecurityCraft.stoneMine = new BlockFullMineBase(Material.ROCK, Blocks.STONE).setCreativeTab(mod_SecurityCraft.tabSCMine).setHardness(!ableToBreakMines ? -1F : 2.5F).setRegistryName("stone_mine").setUnlocalizedName("stoneMine");
		mod_SecurityCraft.cobblestoneMine = new BlockFullMineBase(Material.ROCK, Blocks.COBBLESTONE).setCreativeTab(mod_SecurityCraft.tabSCMine).setHardness(!ableToBreakMines ? -1F : 2.75F).setRegistryName("cobblestone_mine").setUnlocalizedName("cobblestoneMine");
		mod_SecurityCraft.sandMine = new BlockFullMineBase(Material.SAND, Blocks.SAND).setCreativeTab(mod_SecurityCraft.tabSCMine).setHardness(!ableToBreakMines ? -1F : 1.25F).setRegistryName("sand_mine").setUnlocalizedName("sandMine");
		mod_SecurityCraft.diamondOreMine = new BlockFullMineBase(Material.ROCK, Blocks.DIAMOND_ORE).setCreativeTab(mod_SecurityCraft.tabSCMine).setHardness(!ableToBreakMines ? -1F : 3.75F).setRegistryName("diamond_mine").setUnlocalizedName("diamondMine");
		mod_SecurityCraft.furnaceMine = new BlockFurnaceMine(Material.ROCK).setCreativeTab(mod_SecurityCraft.tabSCMine).setHardness(!ableToBreakMines ? -1F : 3.75F).setRegistryName("furnace_mine").setUnlocalizedName("furnaceMine");
				
	    mod_SecurityCraft.trackMine = new BlockTrackMine().setHardness(!ableToBreakMines ? -1F : 0.7F).setCreativeTab(mod_SecurityCraft.tabSCMine).setRegistryName("track_mine").setUnlocalizedName("trackMine");

		mod_SecurityCraft.bouncingBetty = new BlockBouncingBetty(Material.CIRCUITS).setHardness(!ableToBreakMines ? -1F : 1F).setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCMine).setRegistryName("bouncing_betty").setUnlocalizedName("bouncingBetty");
	
		mod_SecurityCraft.claymore = new BlockClaymore(Material.CIRCUITS).setHardness(!ableToBreakMines ? -1F : 1F).setResistance(3F).setCreativeTab(mod_SecurityCraft.tabSCMine).setRegistryName("claymore").setUnlocalizedName("claymore");
	
		mod_SecurityCraft.ims = new BlockIMS(Material.IRON).setBlockUnbreakable().setResistance(1000F).setCreativeTab(mod_SecurityCraft.tabSCMine).setRegistryName("ims").setUnlocalizedName("ims");
	}
	
	public void setupItems(){
		mod_SecurityCraft.codebreaker = new ItemCodebreaker().setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("codebreaker").setUnlocalizedName("codebreaker");
	    
		mod_SecurityCraft.keycardLV1 = new ItemKeycardBase(0).setRegistryName("keycard_lv1").setUnlocalizedName("keycardLV1");
		mod_SecurityCraft.keycardLV2 = new ItemKeycardBase(1).setRegistryName("keycard_lv2").setUnlocalizedName("keycardLV2");
		mod_SecurityCraft.keycardLV3 = new ItemKeycardBase(2).setRegistryName("keycard_lv3").setUnlocalizedName("keycardLV3");
		mod_SecurityCraft.keycardLV4 = new ItemKeycardBase(4).setRegistryName("keycard_lv4").setUnlocalizedName("keycardLV4");
		mod_SecurityCraft.keycardLV5 = new ItemKeycardBase(5).setRegistryName("keycard_lv5").setUnlocalizedName("keycardLV5");
		mod_SecurityCraft.limitedUseKeycard = new ItemKeycardBase(3).setRegistryName("limited_use_keycard").setUnlocalizedName("limitedUseKeycard");

		mod_SecurityCraft.reinforcedDoorItem = new ItemReinforcedDoor().setRegistryName("door_indestructible_iron_item").setUnlocalizedName("doorIndestructibleIronItem").setCreativeTab(mod_SecurityCraft.tabSCDecoration);
		
		mod_SecurityCraft.universalBlockRemover = new ItemUniversalBlockRemover().setMaxStackSize(1).setMaxDamage(476).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("universal_block_remover").setUnlocalizedName("universalBlockRemover");
		
		mod_SecurityCraft.remoteAccessMine = new ItemMineRemoteAccessTool().setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("remote_access_mine").setUnlocalizedName("remoteAccessMine");
		
		mod_SecurityCraft.fWaterBucket = new ItemModifiedBucket(mod_SecurityCraft.bogusWaterFlowing).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("bucket_f_water").setUnlocalizedName("bucketFWater");
		
		mod_SecurityCraft.fLavaBucket = new ItemModifiedBucket(mod_SecurityCraft.bogusLavaFlowing).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("bucket_f_lava").setUnlocalizedName("bucketFLava");

		mod_SecurityCraft.universalBlockModifier = new ItemUniversalBlockModifier().setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("universal_block_modifier").setUnlocalizedName("universalBlockModifier");
	
		mod_SecurityCraft.redstoneModule = (ItemModule) new ItemModule(EnumCustomModules.REDSTONE, false).setRegistryName("redstone_module").setUnlocalizedName("redstoneModule");
		mod_SecurityCraft.whitelistModule = (ItemModule) new ItemModule(EnumCustomModules.WHITELIST, true).setRegistryName("whitelist_module").setUnlocalizedName("whitelistModule");
		mod_SecurityCraft.blacklistModule = (ItemModule) new ItemModule(EnumCustomModules.BLACKLIST, true).setRegistryName("blacklist_module").setUnlocalizedName("blacklistModule");
		mod_SecurityCraft.harmingModule = (ItemModule) new ItemModule(EnumCustomModules.HARMING, false).setRegistryName("harming_module").setUnlocalizedName("harmingModule");
		mod_SecurityCraft.smartModule = (ItemModule) new ItemModule(EnumCustomModules.SMART, false).setRegistryName("smart_module").setUnlocalizedName("smartModule");
		mod_SecurityCraft.storageModule = (ItemModule) new ItemModule(EnumCustomModules.STORAGE, false).setRegistryName("storage_module").setUnlocalizedName("storageModule");
		mod_SecurityCraft.disguiseModule = (ItemModule) new ItemModule(EnumCustomModules.DISGUISE, false, true, GuiHandler.DISGUISE_MODULE, 0, 1).setRegistryName("disguise_module").setUnlocalizedName("disguiseModule");

		mod_SecurityCraft.wireCutters = new Item().setMaxStackSize(1).setMaxDamage(476).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("wire_cutters").setUnlocalizedName("wireCutters");
	
		mod_SecurityCraft.keyPanel = new ItemKeyPanel().setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("keypad_item").setUnlocalizedName("keypadItem");
		
		mod_SecurityCraft.adminTool = new ItemAdminTool().setMaxStackSize(1).setRegistryName("admin_tool").setUnlocalizedName("adminTool");
	
		mod_SecurityCraft.cameraMonitor = new ItemCameraMonitor().setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("camera_monitor").setUnlocalizedName("cameraMonitor");
	
		mod_SecurityCraft.scManual = new ItemSCManual().setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("sc_manual").setUnlocalizedName("scManual");
	
		mod_SecurityCraft.taser = new ItemTaser().setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("taser").setUnlocalizedName("taser");
	
		mod_SecurityCraft.universalOwnerChanger = new ItemUniversalOwnerChanger().setMaxStackSize(1).setMaxDamage(48).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("universal_owner_changer").setUnlocalizedName("universalOwnerChanger");

		
		mod_SecurityCraft.universalBlockReinforcerLvL1 = new ItemUniversalBlockReinforcer(300).setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("universal_block_reinforcer_lvl1").setUnlocalizedName("universalBlockReinforcerLvL1");
		mod_SecurityCraft.universalBlockReinforcerLvL2 = new ItemUniversalBlockReinforcer(2700).setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("universal_block_reinforcer_lvl2").setUnlocalizedName("universalBlockReinforcerLvL2");
		mod_SecurityCraft.universalBlockReinforcerLvL3 = new ItemUniversalBlockReinforcer(0).setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("universal_block_reinforcer_lvl3").setUnlocalizedName("universalBlockReinforcerLvL3");
	
	    mod_SecurityCraft.briefcase = new ItemBriefcase().setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("briefcase").setUnlocalizedName("briefcase");
	
	    mod_SecurityCraft.universalKeyChanger = new ItemUniversalKeyChanger().setMaxStackSize(1).setCreativeTab(mod_SecurityCraft.tabSCTechnical).setRegistryName("universal_key_changer").setUnlocalizedName("universalKeyChanger");
	    
	    mod_SecurityCraft.scannerDoorItem = new ItemScannerDoor().setRegistryName("scanner_door_item").setUnlocalizedName("scannerDoorItem").setCreativeTab(mod_SecurityCraft.tabSCDecoration);
	}
	
	public void setupDebuggingBlocks() {}
	
	public void setupConfiguration() {
		mod_SecurityCraft.configFile.load();

		Property dummyProp;

		dummyProp = mod_SecurityCraft.configFile.get("options", "Is codebreaker allowed?", true);
		dummyProp.setLanguageKey("config.isCodebreakerAllowed");
		allowCodebreakerItem = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Is admin tool allowed?", false);
		dummyProp.setLanguageKey("config.allowAdminTool");
		allowAdminTool = dummyProp.getBoolean(false);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Mine(s) spawn fire when detonated?", true);
		dummyProp.setLanguageKey("config.shouldSpawnFire");
		shouldSpawnFire = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Are mines unbreakable?", true);
		dummyProp.setLanguageKey("config.ableToBreakMines");
		ableToBreakMines = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Craftable level 1 keycard?", true);
		dummyProp.setLanguageKey("config.ableToCraftKeycard1");
		ableToCraftKeycard1 = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Craftable level 2 keycard?", true);
		dummyProp.setLanguageKey("config.ableToCraftKeycard2");
		ableToCraftKeycard2 = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Craftable level 3 keycard?", true);
		dummyProp.setLanguageKey("config.ableToCraftKeycard3");
		ableToCraftKeycard3 = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Craftable level 4 keycard?", true);
		dummyProp.setLanguageKey("config.ableToCraftKeycard4");
		ableToCraftKeycard4 = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Craftable level 5 keycard?", true);
		dummyProp.setLanguageKey("config.ableToCraftKeycard5");
		ableToCraftKeycard5 = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Craftable Limited Use keycard?", true);
		dummyProp.setLanguageKey("config.ableToCraftLUKeycard");
		ableToCraftLUKeycard = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Mines use a smaller explosion?", false);
		dummyProp.setLanguageKey("config.smallerMineExplosion");
		smallerMineExplosion = dummyProp.getBoolean(false);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Mines explode when broken in Creative?", true);
		dummyProp.setLanguageKey("config.mineExplodesWhenInCreative");
		mineExplodesWhenInCreative = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Portable radar search radius:", 25);
		dummyProp.setLanguageKey("config.portableRadarSearchRadius");
		portableRadarSearchRadius = dummyProp.getDouble(25);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Username logger search radius:", 3);
		dummyProp.setLanguageKey("config.usernameLoggerSearchRadius");
		usernameLoggerSearchRadius = dummyProp.getInt(3);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Laser range:", 5);
		dummyProp.setLanguageKey("config.laserBlockRange");
		laserBlockRange = dummyProp.getInt(5);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Delay between alarm sounds (seconds):", 2);
		dummyProp.setLanguageKey("config.alarmTickDelay");
		alarmTickDelay = dummyProp.getInt(2);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Alarm sound volume:", 0.8D);
		dummyProp.setLanguageKey("config.alarmSoundVolume");
		alarmSoundVolume = dummyProp.getDouble(0.8D);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Portable radar delay (seconds):", 4);
		dummyProp.setLanguageKey("config.portableRadarDelay");
		portableRadarDelay = dummyProp.getInt(4);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Claymore range:", 5);
		dummyProp.setLanguageKey("config.claymoreRange");
		claymoreRange = dummyProp.getInt(5);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "IMS range:", 12);
		dummyProp.setLanguageKey("config.imsRange");
		imsRange = dummyProp.getInt(12);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Display a 'tip' message at spawn?", true);
		dummyProp.setLanguageKey("config.sayThanksMessage");
		sayThanksMessage = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Is debug mode? (not recommended!)", false);
		dummyProp.setLanguageKey("config.debuggingMode");
		mod_SecurityCraft.debuggingMode = dummyProp.getBoolean(false);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Is IRC bot enabled?", true);
		dummyProp.setLanguageKey("config.isIrcBotEnabled");
		isIrcBotEnabled = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Disconnect IRC bot on world exited?", true);
		dummyProp.setLanguageKey("config.disconnectOnWorldClose");
		disconnectOnWorldClose = dummyProp.getBoolean(true);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Use old keypad recipe (9 buttons)?", false);
		dummyProp.setLanguageKey("config.useOldKeypadRecipe");
		useOldKeypadRecipe = dummyProp.getBoolean(false);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Camera Speed when not using LookingGlass:", 2);
		dummyProp.setLanguageKey("config.cameraSpeed");
		cameraSpeed = dummyProp.getInt(2);
		
		dummyProp = mod_SecurityCraft.configFile.get("options", "Should check for updates on Github?", true);
		dummyProp.setLanguageKey("config.checkForUpdates");
		checkForUpdates = dummyProp.getBoolean(true);

        if(mod_SecurityCraft.configFile.hasChanged()){
        	mod_SecurityCraft.configFile.save();
        }
	}
	
	public void setupGameRegistry(){
		registerBlock(mod_SecurityCraft.laserBlock);
		registerBlock(mod_SecurityCraft.laser);
		registerBlock(mod_SecurityCraft.keypad);
		registerBlock(mod_SecurityCraft.mine);
		registerBlock(mod_SecurityCraft.mineCut);
		registerBlock(mod_SecurityCraft.dirtMine);
		registerBlock(mod_SecurityCraft.stoneMine);
		registerBlock(mod_SecurityCraft.cobblestoneMine);
		registerBlock(mod_SecurityCraft.diamondOreMine);
		registerBlock(mod_SecurityCraft.sandMine);
		registerBlock(mod_SecurityCraft.furnaceMine);
		registerBlock(mod_SecurityCraft.retinalScanner);
		registerBlock(mod_SecurityCraft.reinforcedDoor);
		registerBlock(mod_SecurityCraft.bogusLava);
		registerBlock(mod_SecurityCraft.bogusLavaFlowing);
		registerBlock(mod_SecurityCraft.bogusWater);
		registerBlock(mod_SecurityCraft.bogusWaterFlowing);
		registerBlock(mod_SecurityCraft.keycardReader);
		registerBlock(mod_SecurityCraft.ironTrapdoor);
		registerBlock(mod_SecurityCraft.bouncingBetty);
		registerBlock(mod_SecurityCraft.inventoryScanner);
		registerBlock(mod_SecurityCraft.inventoryScannerField);
		registerBlock(mod_SecurityCraft.trackMine);
		registerBlock(mod_SecurityCraft.cageTrap);
		registerBlock(mod_SecurityCraft.portableRadar);
		registerBlock(mod_SecurityCraft.unbreakableIronBars);
		registerBlockWithCustomRecipe(mod_SecurityCraft.keypadChest, new ItemStack[]{ null, ItemUtils.toItemStack(mod_SecurityCraft.keyPanel), null, null, ItemUtils.toItemStack(Items.REDSTONE), null, null, ItemUtils.toItemStack(Item.getItemFromBlock(Blocks.CHEST)), null});
		registerBlock(mod_SecurityCraft.usernameLogger);
		registerBlock(mod_SecurityCraft.alarm);
		registerBlock(mod_SecurityCraft.alarmLit);
		registerBlock(mod_SecurityCraft.reinforcedStone);
		registerBlock(mod_SecurityCraft.reinforcedSandstone, new ItemBlockReinforcedSandstone(mod_SecurityCraft.reinforcedSandstone));
		registerBlock(mod_SecurityCraft.reinforcedDirt);
		registerBlock(mod_SecurityCraft.reinforcedCobblestone);
		registerBlock(mod_SecurityCraft.reinforcedFencegate);
		registerBlock(mod_SecurityCraft.reinforcedWoodPlanks, new ItemBlockReinforcedPlanks(mod_SecurityCraft.reinforcedWoodPlanks));
		registerBlock(mod_SecurityCraft.panicButton);
		registerBlock(mod_SecurityCraft.frame);
		registerBlock(mod_SecurityCraft.claymore);
		registerBlock(mod_SecurityCraft.keypadFurnace);
		registerBlock(mod_SecurityCraft.securityCamera);
		registerBlock(mod_SecurityCraft.reinforcedStairsOak);
		registerBlock(mod_SecurityCraft.reinforcedStairsSpruce);
		registerBlock(mod_SecurityCraft.reinforcedStairsCobblestone);
		registerBlock(mod_SecurityCraft.reinforcedStairsSandstone);
		registerBlock(mod_SecurityCraft.reinforcedStairsBirch);
		registerBlock(mod_SecurityCraft.reinforcedStairsJungle);
		registerBlock(mod_SecurityCraft.reinforcedStairsAcacia);
		registerBlock(mod_SecurityCraft.reinforcedStairsDarkoak);
		registerBlock(mod_SecurityCraft.reinforcedStairsStone);
		registerBlock(mod_SecurityCraft.ironFence);
		registerBlock(mod_SecurityCraft.ims);
		registerBlock(mod_SecurityCraft.reinforcedGlass);
		registerBlock(mod_SecurityCraft.reinforcedStainedGlass, new ItemBlockReinforcedStainedGlass(mod_SecurityCraft.reinforcedStainedGlass));
		registerBlock(mod_SecurityCraft.reinforcedWoodSlabs, new ItemBlockReinforcedWoodSlabs(mod_SecurityCraft.reinforcedWoodSlabs));
		registerBlock(mod_SecurityCraft.reinforcedDoubleWoodSlabs);
		registerBlock(mod_SecurityCraft.reinforcedStoneSlabs, new ItemBlockReinforcedSlabs(mod_SecurityCraft.reinforcedStoneSlabs));
		registerBlock(mod_SecurityCraft.reinforcedDoubleStoneSlabs);
		registerBlock(mod_SecurityCraft.protecto);
		registerBlock(mod_SecurityCraft.scannerDoor);

		registerItem(mod_SecurityCraft.codebreaker);
	    registerItem(mod_SecurityCraft.reinforcedDoorItem);
	    registerItem(mod_SecurityCraft.scannerDoorItem);
		registerItem(mod_SecurityCraft.universalBlockRemover);
		registerItem(mod_SecurityCraft.keycardLV1);
		registerItem(mod_SecurityCraft.keycardLV2);
		registerItem(mod_SecurityCraft.keycardLV3);
		registerItem(mod_SecurityCraft.keycardLV4);
		registerItem(mod_SecurityCraft.keycardLV5);
		registerItem(mod_SecurityCraft.limitedUseKeycard);
		registerItem(mod_SecurityCraft.remoteAccessMine);
		registerItem(mod_SecurityCraft.fWaterBucket);
		registerItem(mod_SecurityCraft.fLavaBucket);
		registerItem(mod_SecurityCraft.universalBlockModifier);
		registerItem(mod_SecurityCraft.redstoneModule);
		registerItem(mod_SecurityCraft.whitelistModule);
		registerItem(mod_SecurityCraft.blacklistModule);
		registerItem(mod_SecurityCraft.harmingModule);
		registerItem(mod_SecurityCraft.smartModule);
		registerItem(mod_SecurityCraft.storageModule);
		registerItem(mod_SecurityCraft.disguiseModule);
		registerItem(mod_SecurityCraft.wireCutters);
		registerItem(mod_SecurityCraft.adminTool);
		registerItem(mod_SecurityCraft.keyPanel);
		registerItem(mod_SecurityCraft.cameraMonitor);
		registerItem(mod_SecurityCraft.taser);
		registerItem(mod_SecurityCraft.scManual);
		registerItem(mod_SecurityCraft.universalOwnerChanger);
		registerItem(mod_SecurityCraft.universalBlockReinforcerLvL1);
		registerItem(mod_SecurityCraft.universalBlockReinforcerLvL2);
		registerItem(mod_SecurityCraft.universalBlockReinforcerLvL3);
		registerItem(mod_SecurityCraft.briefcase);
		registerItem(mod_SecurityCraft.universalKeyChanger);

		GameRegistry.registerTileEntity(TileEntityOwnable.class, "abstractOwnable");
		GameRegistry.registerTileEntity(TileEntitySCTE.class, "abstractSC");
		GameRegistry.registerTileEntity(TileEntityKeypad.class, "keypad");
		GameRegistry.registerTileEntity(TileEntityLaserBlock.class, "laserBlock");
		GameRegistry.registerTileEntity(TileEntityCageTrap.class, "cageTrap");
		GameRegistry.registerTileEntity(TileEntityKeycardReader.class, "keycardReader");
		GameRegistry.registerTileEntity(TileEntityInventoryScanner.class, "inventoryScanner");
		GameRegistry.registerTileEntity(TileEntityPortableRadar.class, "portableRadar");
		GameRegistry.registerTileEntity(TileEntitySecurityCamera.class, "securityCamera");
		GameRegistry.registerTileEntity(TileEntityLogger.class, "usernameLogger");
		GameRegistry.registerTileEntity(TileEntityRetinalScanner.class, "retinalScanner");
		GameRegistry.registerTileEntity(TileEntityKeypadChest.class, "keypadChest");
		GameRegistry.registerTileEntity(TileEntityAlarm.class, "alarm");
		GameRegistry.registerTileEntity(TileEntityClaymore.class, "claymore");
		GameRegistry.registerTileEntity(TileEntityKeypadFurnace.class, "keypadFurnace");
		GameRegistry.registerTileEntity(TileEntityIMS.class, "ims");
		GameRegistry.registerTileEntity(TileEntityProtecto.class, "protecto");
		GameRegistry.registerTileEntity(CustomizableSCTE.class, "customizableSCTE");
		GameRegistry.registerTileEntity(TileEntityScannerDoor.class, "scannerDoor");

		for(int i = 0; i < SCSounds.values().length; i++)
		{
			int registrySize = SoundEvent.REGISTRY.getKeys().size();
			SoundEvent.REGISTRY.register(registrySize + i, SCSounds.values()[i].location, SCSounds.values()[i].event);
		}
				
		if(useOldKeypadRecipe){
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keypad, 1), new Object[]{
				"III", "III", "III", 'I', Blocks.STONE_BUTTON
			});
		} else {
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keyPanel, 1), new Object[]{
				"III", "IBI", "III", 'I', Blocks.STONE_BUTTON, 'B', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE
			});
			
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.frame, 1), new Object[]{
				"III", "IBI", "I I", 'I', Items.IRON_INGOT, 'B', Items.REDSTONE
			});
		}
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.laserBlock, 1), new Object[]{
			"III", "IBI", "IPI", 'I', Blocks.STONE, 'B', Blocks.REDSTONE_BLOCK, 'P', Blocks.GLASS_PANE
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.mine, 3), new Object[]{
			" I ", "IBI", 'I', Items.IRON_INGOT, 'B', Items.GUNPOWDER
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedDoorItem, 1), new Object[]{
			"III", "IDI", "III", 'I', Items.IRON_INGOT, 'D', Items.IRON_DOOR
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.universalBlockRemover, 1), new Object[]{
			"SII",'I', Items.IRON_INGOT, 'S', Items.SHEARS
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.ironTrapdoor, 1), new Object[]{
			"###", "#P#", "###", '#', Items.IRON_INGOT, 'P', Blocks.TRAPDOOR
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keycardReader, 1), new Object[]{
			"SSS", "SHS", "SSS", 'S', Blocks.STONE, 'H', Blocks.HOPPER
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.bouncingBetty, 1), new Object[]{
			" P ", "IBI", 'I', Items.IRON_INGOT, 'B', Items.GUNPOWDER, 'P', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.codebreaker, 1), new Object[]{
			"DTD", "GSG", "RER", 'D', Items.DIAMOND, 'T', Blocks.REDSTONE_TORCH, 'G', Items.GOLD_INGOT, 'S', Items.NETHER_STAR, 'R', Items.REDSTONE, 'E', Items.EMERALD
		});
		
		if(ableToCraftKeycard1){
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keycardLV1, 1), new Object[]{
				"III", "YYY", 'I', Items.IRON_INGOT, 'Y', Items.GOLD_INGOT 
			});
		}
		
		if(ableToCraftKeycard2){
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keycardLV2, 1), new Object[]{
				"III", "YYY", 'I', Items.IRON_INGOT, 'Y', Items.BRICK
			});
		}
		
		if(ableToCraftKeycard3){ 
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keycardLV3, 1), new Object[]{
				"III", "YYY", 'I', Items.IRON_INGOT, 'Y', Items.NETHERBRICK
			});
		}
		
		if(ableToCraftKeycard4){
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keycardLV4, 1), new Object[]{
				"III", "DDD", 'I', Items.IRON_INGOT, 'D', new ItemStack(Items.DYE, 1, 13)
			});
		}
		
		if(ableToCraftKeycard5){
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keycardLV5, 1), new Object[]{
				"III", "DDD", 'I', Items.IRON_INGOT, 'D', new ItemStack(Items.DYE, 1, 5)
			});
		}
		
		if(ableToCraftLUKeycard){
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.limitedUseKeycard, 1), new Object[]{
				"III", "LLL", 'I', Items.IRON_INGOT, 'L', new ItemStack(Items.DYE, 1, 4)
			});
		}
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.trackMine, 4), new Object[]{
			"X X", "X#X", "XGX", 'X', Items.IRON_INGOT, '#', Items.STICK, 'G', Items.GUNPOWDER
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.portableRadar, 1), new Object[]{
			"III", "ITI", "IRI", 'I', Items.IRON_INGOT, 'T', Blocks.REDSTONE_TORCH, 'R', Items.REDSTONE
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keypadChest, 1), new Object[]{
			"K", "R", "C", 'K', mod_SecurityCraft.keyPanel, 'R', Items.REDSTONE, 'C', Blocks.CHEST
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.remoteAccessMine, 1), new Object[]{
			" R ", " DG", "S  ", 'R', Blocks.REDSTONE_TORCH, 'D', Items.DIAMOND, 'G', Items.GOLD_INGOT, 'S', Items.STICK
		});
		
		for(int i = 0; i < 4; i++){
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.fWaterBucket, 1), new Object[]{
				"P", "B", 'P', new ItemStack(Items.POTIONITEM, 1, harmingPotions[i]), 'B', Items.WATER_BUCKET
			});
		}
		
		for(int i = 0; i < 4; i++){
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.fLavaBucket, 1), new Object[]{
				"P", "B", 'P', new ItemStack(Items.POTIONITEM, 1, healingPotions[i]), 'B', Items.LAVA_BUCKET
			});
		}
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.retinalScanner, 1), new Object[]{
			"SSS", "SES", "SSS", 'S', Blocks.STONE, 'E', Items.ENDER_EYE
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.inventoryScanner, 1), new Object[]{
			"SSS", "SLS", "SCS", 'S', Blocks.STONE, 'L', mod_SecurityCraft.laserBlock, 'C', Blocks.ENDER_CHEST
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.cageTrap, 1), new Object[]{
			"BBB", "GRG", "III", 'B', mod_SecurityCraft.unbreakableIronBars, 'G', Items.GOLD_INGOT, 'R', Items.REDSTONE, 'I', Blocks.IRON_BLOCK
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.alarm, 1), new Object[]{
			"GGG", "GNG", "GRG", 'G', Blocks.GLASS, 'R', Items.REDSTONE, 'N', Blocks.NOTEBLOCK
		});
		
//		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedFencegate, 1), new Object[]{
//			" I ", "IFI", " I ", 'I', Items.IRON_INGOT, 'F', Blocks.fence_gate
//		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.wireCutters, 1), new Object[]{
			"SI ", "I I", " I ", 'I', Items.IRON_INGOT, 'S', Items.SHEARS
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.panicButton, 1), new Object[]{
			" I ", "IBI", " R ", 'I', Items.IRON_INGOT, 'B', Blocks.STONE_BUTTON, 'R', Items.REDSTONE
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.whitelistModule, 1), new Object[]{
			"III", "IPI", "IPI", 'I', Items.IRON_INGOT, 'P', Items.PAPER
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.blacklistModule, 1), new Object[]{
			"III", "IPI", "IDI", 'I', Items.IRON_INGOT, 'P', Items.PAPER, 'D', new ItemStack(Items.DYE, 1, 0)
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.redstoneModule, 1), new Object[]{
			"III", "IPI", "IRI", 'I', Items.IRON_INGOT, 'P', Items.PAPER, 'R', Items.REDSTONE
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.harmingModule, 1), new Object[]{
			"III", "IPI", "IAI", 'I', Items.IRON_INGOT, 'P', Items.PAPER, 'A', Items.ARROW
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.smartModule, 1), new Object[]{
			"III", "IPI", "IEI", 'I', Items.IRON_INGOT, 'P', Items.PAPER, 'E', Items.ENDER_PEARL
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.storageModule, 1), new Object[]{
			"III", "IPI", "ICI", 'I', Items.IRON_INGOT, 'P', Items.PAPER, 'C', mod_SecurityCraft.keypadChest
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.disguiseModule, 1), new Object[]{
				"III", "IPI", "IAI", 'I', Items.IRON_INGOT, 'P', Items.PAPER, 'A', Items.PAINTING
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.universalBlockModifier, 1), new Object[]{
			"ER ", "RI ", "  I", 'E', Items.EMERALD, 'R', Items.REDSTONE, 'I', Items.IRON_INGOT
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.universalBlockModifier, 1), new Object[]{
			" RE", " IR", "I  ", 'E', Items.EMERALD, 'R', Items.REDSTONE, 'I', Items.IRON_INGOT
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.usernameLogger, 1), new Object[]{
			"SPS", "SRS", "SSS", 'S', Blocks.STONE, 'P', mod_SecurityCraft.portableRadar, 'R', Items.REDSTONE
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.keypadFurnace, 1), new Object[]{
			"K", "F", "P", 'K', mod_SecurityCraft.frame, 'F', Blocks.FURNACE, 'P', mod_SecurityCraft.keyPanel
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.claymore, 1), new Object[]{
			"HSH", "SBS", "RGR", 'H', Blocks.TRIPWIRE_HOOK, 'S', Items.STRING, 'B', mod_SecurityCraft.bouncingBetty, 'R', Items.REDSTONE, 'G', Items.GUNPOWDER
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.ironFence, 1), new Object[]{
			" I ", "IFI", " I ", 'I', Items.IRON_INGOT, 'F', Blocks.OAK_FENCE
	    });
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsStone, 4), new Object[]{
			"S  ", "SS ", "SSS", 'S', mod_SecurityCraft.reinforcedStone
	    });
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsCobblestone, 4), new Object[]{
				"S  ", "SS ", "SSS", 'S', mod_SecurityCraft.reinforcedCobblestone
		    });
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsSandstone, 4), new Object[]{
				"S  ", "SS ", "SSS", 'S', mod_SecurityCraft.reinforcedSandstone
		    });
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsOak, 4), new Object[]{
		    "W  ", "WW ", "WWW", 'W', new ItemStack(mod_SecurityCraft.reinforcedWoodPlanks, 1, 0)
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsSpruce, 4), new Object[]{
			"W  ", "WW ", "WWW", 'W', new ItemStack(mod_SecurityCraft.reinforcedWoodPlanks, 1, 1)
	    });
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsBirch, 4), new Object[]{
		    "W  ", "WW ", "WWW", 'W', new ItemStack(mod_SecurityCraft.reinforcedWoodPlanks, 1, 2)
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsJungle, 4), new Object[]{
			"W  ", "WW ", "WWW", 'W', new ItemStack(mod_SecurityCraft.reinforcedWoodPlanks, 1, 3)
	    });
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsAcacia, 4), new Object[]{
		    "W  ", "WW ", "WWW", 'W', new ItemStack(mod_SecurityCraft.reinforcedWoodPlanks, 1, 4)
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStairsDarkoak, 4), new Object[]{
			"W  ", "WW ", "WWW", 'W', new ItemStack(mod_SecurityCraft.reinforcedWoodPlanks, 1, 5)
	    });
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.ims, 1), new Object[]{
		    "BPB", " I ", "B B", 'B', mod_SecurityCraft.bouncingBetty, 'P', mod_SecurityCraft.portableRadar, 'I', Blocks.IRON_BLOCK
		});
        
        GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.cameraMonitor, 1), new Object[]{
		    "III", "IGI", "III", 'I', Items.IRON_INGOT, 'G', Blocks.GLASS_PANE
		});
        
        GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.taser, 1), new Object[]{
    		"BGI", "RSG", "  S", 'B', Items.BOW, 'G', Items.GOLD_INGOT, 'I', Items.IRON_INGOT, 'R', Items.REDSTONE, 'S', Items.STICK
        });
        
        GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.securityCamera, 1), new Object[]{
        	"III", "GRI", "IIS", 'I', Items.IRON_INGOT, 'G', mod_SecurityCraft.reinforcedGlass, 'R', Blocks.REDSTONE_BLOCK, 'S', Items.STICK
        });

        for(int i = 0; i < 16; i++){
        	GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStainedGlass, 8, 15 - i), new Object[]{
        		"###", "#X#", "###", '#', new ItemStack(mod_SecurityCraft.reinforcedGlass), 'X', new ItemStack(Items.DYE, 1, i)
        	});
        	
        	GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedGlass, 16, i - 1), new Object[]{
        		"###", "###", '#', new ItemStack(mod_SecurityCraft.reinforcedStainedGlass, 1, i)
        	});
        }
	
        GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.universalBlockReinforcerLvL1, 1), new Object[]{
        		" DG", "RLD", "SR ", 'G', Blocks.GLASS, 'D', Items.DIAMOND, 'L', mod_SecurityCraft.laserBlock, 'R', Items.REDSTONE, 'S', Items.STICK
        });
        
        GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.universalBlockReinforcerLvL2, 1), new Object[]{
        		" DG", "RLD", "SR ", 'G', new ItemStack(mod_SecurityCraft.reinforcedStainedGlass, 1, 15), 'D', Blocks.DIAMOND_BLOCK, 'L', mod_SecurityCraft.laserBlock, 'R', Items.REDSTONE, 'S', Items.STICK
        });
        
        GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.universalBlockReinforcerLvL3, 1), new Object[]{
        		" EG", "RNE", "SR ", 'G', new ItemStack(mod_SecurityCraft.reinforcedStainedGlass, 1, 6), 'E', Blocks.EMERALD_BLOCK, 'N', Items.NETHER_STAR, 'R', Blocks.REDSTONE_BLOCK, 'S', Items.STICK
        });
        
		for(int i = 0; i < 6; i++)
		{
			GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedWoodSlabs, 6, i), new Object[]{
					"MMM", 'M', new ItemStack(mod_SecurityCraft.reinforcedWoodPlanks, 1, i)
			});
		}

		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStoneSlabs, 6, 0), new Object[]{
				"MMM", 'M', mod_SecurityCraft.reinforcedStone
		});

		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStoneSlabs, 6, 1), new Object[]{
				"MMM", 'M', mod_SecurityCraft.reinforcedCobblestone
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.reinforcedStoneSlabs, 6, 2), new Object[]{
				"MMM", 'M', mod_SecurityCraft.reinforcedSandstone
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.protecto, 1), new Object[]{
				"ODO", "OEO", "OOO", 'O', Blocks.OBSIDIAN, 'D', Blocks.DAYLIGHT_DETECTOR, 'E', Items.ENDER_EYE
		});
		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.briefcase, 1), new Object[]{
				"SSS", "ICI", "III", 'S', Items.STICK, 'I', Items.IRON_INGOT, 'C', Blocks.CHEST
		});

		
		GameRegistry.addRecipe(new ItemStack(mod_SecurityCraft.universalKeyChanger, 1), new Object[]{
				" RL", " IR", "I  ", 'R', Items.REDSTONE, 'L', mod_SecurityCraft.laserBlock, 'I', Items.IRON_INGOT
		});
		
        GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.dirtMine, 1), new Object[] {Blocks.DIRT, mod_SecurityCraft.mine});
        GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.stoneMine, 1), new Object[] {Blocks.STONE, mod_SecurityCraft.mine});
        GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.cobblestoneMine, 1), new Object[] {Blocks.COBBLESTONE, mod_SecurityCraft.mine});
        GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.diamondOreMine, 1), new Object[] {Blocks.DIAMOND_ORE, mod_SecurityCraft.mine});
        GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.sandMine, 1), new Object[] {Blocks.SAND, mod_SecurityCraft.mine});
        GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.furnaceMine, 1), new Object[] {Blocks.FURNACE, mod_SecurityCraft.mine});
        GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.universalOwnerChanger, 1), new Object[] {mod_SecurityCraft.universalBlockModifier, Items.NAME_TAG});
        GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.scannerDoorItem), new Object[]{mod_SecurityCraft.reinforcedDoorItem, mod_SecurityCraft.retinalScanner});
		GameRegistry.addShapelessRecipe(new ItemStack(mod_SecurityCraft.universalKeyChanger), new Object[]{mod_SecurityCraft.universalKeyChanger, mod_SecurityCraft.briefcase});
	}

	/**
	 * Registers a block and its ItemBlock
	 * @param block The block to register
	 */
	private void registerBlock(Block block)
	{
		registerBlock(block, new ItemBlock(block));
	}
	
	/**
	 * Registers a block with a custom ItemBlock and adds the help info for the block to the SecurityCraft manual item
	 * @param block The Block to register
	 * @param itemBlock The ItemBlock to register
	 */
	private void registerBlock(Block block, ItemBlock itemBlock){
		GameRegistry.register(block);
		GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName().toString()));
		
		mod_SecurityCraft.instance.manualPages.add(new SCManualPage(Item.getItemFromBlock(block), ClientUtils.localize("help." + block.getUnlocalizedName().substring(5) + ".info")));
	}
	
	/**
	 * Registers the given block with GameRegistry.registerBlock(), and adds the help info for the block to the SecurityCraft manual item.
	 * Also overrides the default recipe that would've been drawn in the manual with a new recipe.
	 * 
	 */
	private void registerBlockWithCustomRecipe(Block block, ItemStack... customRecipe){ 
		GameRegistry.register(block);
		GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName().toString()));

		mod_SecurityCraft.instance.manualPages.add(new SCManualPage(Item.getItemFromBlock(block), ClientUtils.localize("help." + block.getUnlocalizedName().substring(5) + ".info"), customRecipe));
	}
	
	/**
	 * Registers the given item with GameRegistry.registerItem(), and adds the help info for the item to the SecurityCraft manual item.
	 */
	private void registerItem(Item item){
		GameRegistry.register(item);
		mod_SecurityCraft.instance.manualPages.add(new SCManualPage(item, ClientUtils.localize("help." + item.getUnlocalizedName().substring(5) + ".info")));
	}
	
	public void setupOtherRegistries(){
		EnumCustomModules.refresh();
	}

	public void setupEntityRegistry() {
		EntityRegistry.registerModEntity(new ResourceLocation("securitycraft", "bouncingbetty"), EntityBouncingBetty.class, "BBetty", 0, mod_SecurityCraft.instance, 128, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("securitycraft", "taserbullet"), EntityTaserBullet.class, "TazerBullet", 2, mod_SecurityCraft.instance, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("securitycraft", "imsbomb"), EntityIMSBomb.class, "IMSBomb", 3, mod_SecurityCraft.instance, 256, 1, true);
		EntityRegistry.registerModEntity(new ResourceLocation("securitycraft", "securitycamera"), EntitySecurityCamera.class, "SecurityCamera", 4, mod_SecurityCraft.instance, 256, 20, false);
	}

	public void setupHandlers(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(mod_SecurityCraft.eventHandler);
	} 

	public void setupPackets(SimpleNetworkWrapper network) {
		network.registerMessage(PacketSetBlock.Handler.class, PacketSetBlock.class, 1, Side.SERVER);
		network.registerMessage(PacketSetISType.Handler.class, PacketSetISType.class, 2, Side.SERVER);
		network.registerMessage(PacketSetKeycardLevel.Handler.class, PacketSetKeycardLevel.class, 3, Side.SERVER);
		network.registerMessage(PacketUpdateLogger.Handler.class, PacketUpdateLogger.class, 4, Side.CLIENT);
		network.registerMessage(PacketCUpdateNBTTag.Handler.class, PacketCUpdateNBTTag.class, 5, Side.CLIENT);
		network.registerMessage(PacketSUpdateNBTTag.Handler.class, PacketSUpdateNBTTag.class, 6, Side.SERVER);
		network.registerMessage(PacketCPlaySoundAtPos.Handler.class, PacketCPlaySoundAtPos.class, 7, Side.CLIENT);
		network.registerMessage(PacketSetExplosiveState.Handler.class, PacketSetExplosiveState.class, 8, Side.SERVER);
		network.registerMessage(PacketGivePotionEffect.Handler.class, PacketGivePotionEffect.class, 9, Side.SERVER);
		network.registerMessage(PacketSSetOwner.Handler.class, PacketSSetOwner.class, 10, Side.SERVER);
		network.registerMessage(PacketSAddModules.Handler.class, PacketSAddModules.class, 11, Side.SERVER);
		network.registerMessage(PacketSSetPassword.Handler.class, PacketSSetPassword.class, 12, Side.SERVER);
		network.registerMessage(PacketSCheckPassword.Handler.class, PacketSCheckPassword.class, 13, Side.SERVER);
		network.registerMessage(PacketSSyncTENBTTag.Handler.class, PacketSSyncTENBTTag.class, 14, Side.SERVER);
		network.registerMessage(PacketSMountCamera.Handler.class, PacketSMountCamera.class, 15, Side.SERVER);
		network.registerMessage(PacketSSetCameraRotation.Handler.class, PacketSSetCameraRotation.class, 16, Side.SERVER);
		network.registerMessage(PacketCSetPlayerPositionAndRotation.Handler.class, PacketCSetPlayerPositionAndRotation.class, 17, Side.CLIENT);
		network.registerMessage(PacketSOpenGui.Handler.class, PacketSOpenGui.class, 18, Side.SERVER);
		network.registerMessage(PacketSToggleOption.Handler.class, PacketSToggleOption.class, 19, Side.SERVER);
		network.registerMessage(PacketCRequestTEOwnableUpdate.Handler.class, PacketCRequestTEOwnableUpdate.class, 20, Side.SERVER);
		network.registerMessage(PacketSUpdateTEOwnable.Handler.class, PacketSUpdateTEOwnable.class, 21, Side.CLIENT);
	}

	@SideOnly(Side.CLIENT)
	public void setupTextureRegistry() {
		//Blocks 
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.keypad), 0, new ModelResourceLocation("securitycraft:keypad", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.frame), 0, new ModelResourceLocation("securitycraft:keypad_frame", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStone), 0, new ModelResourceLocation("securitycraft:reinforced_stone", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.laserBlock), 0, new ModelResourceLocation("securitycraft:laser_block", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.laser), 0, new ModelResourceLocation("securitycraft:laser", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.keypadChest), 0, new ModelResourceLocation("securitycraft:keypad_chest", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedDoor), 0, new ModelResourceLocation("securitycraft:reinforced_iron_door", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.ironTrapdoor), 0, new ModelResourceLocation("securitycraft:reinforced_iron_trapdoor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.keycardReader), 0, new ModelResourceLocation("securitycraft:keycard_reader", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.inventoryScanner), 0, new ModelResourceLocation("securitycraft:inventory_scanner", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.cageTrap), 0, new ModelResourceLocation("securitycraft:cage_trap", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.inventoryScannerField), 0, new ModelResourceLocation("securitycraft:inventory_scanner_field", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.retinalScanner), 0, new ModelResourceLocation("securitycraft:retinal_scanner", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.unbreakableIronBars), 0, new ModelResourceLocation("securitycraft:reinforced_iron_bars", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.portableRadar), 0, new ModelResourceLocation("securitycraft:portable_radar", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.alarm), 0, new ModelResourceLocation("securitycraft:alarm", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.alarmLit), 0, new ModelResourceLocation("securitycraft:alarm_lit", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.usernameLogger), 0, new ModelResourceLocation("securitycraft:username_logger", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedFencegate), 0, new ModelResourceLocation("securitycraft:reinforced_fence_gate", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.ironFence), 0, new ModelResourceLocation("securitycraft:electrified_iron_fence", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodPlanks), 0, new ModelResourceLocation("securitycraft:reinforced_planks_oak", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodPlanks), 1, new ModelResourceLocation("securitycraft:reinforced_planks_spruce", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodPlanks), 2, new ModelResourceLocation("securitycraft:reinforced_planks_birch", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodPlanks), 3, new ModelResourceLocation("securitycraft:reinforced_planks_jungle", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodPlanks), 4, new ModelResourceLocation("securitycraft:reinforced_planks_acacia", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodPlanks), 5, new ModelResourceLocation("securitycraft:reinforced_planks_darkoak", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsStone), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_stone", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsCobblestone), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_cobblestone", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsOak), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_oak", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsSpruce), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_spruce", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsBirch), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_birch", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsJungle), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_jungle", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsAcacia), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_acacia", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsDarkoak), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_darkoak", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedGlass), 0, new ModelResourceLocation("securitycraft:reinforced_glass_block", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 0, new ModelResourceLocation("securitycraft:reinforced_stained_glass_white", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 1, new ModelResourceLocation("securitycraft:reinforced_stained_glass_orange", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 2, new ModelResourceLocation("securitycraft:reinforced_stained_glass_magenta", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 3, new ModelResourceLocation("securitycraft:reinforced_stained_glass_light_blue", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 4, new ModelResourceLocation("securitycraft:reinforced_stained_glass_yellow", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 5, new ModelResourceLocation("securitycraft:reinforced_stained_glass_lime", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 6, new ModelResourceLocation("securitycraft:reinforced_stained_glass_pink", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 7, new ModelResourceLocation("securitycraft:reinforced_stained_glass_gray", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 8, new ModelResourceLocation("securitycraft:reinforced_stained_glass_silver", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 9, new ModelResourceLocation("securitycraft:reinforced_stained_glass_cyan", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 10, new ModelResourceLocation("securitycraft:reinforced_stained_glass_purple", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 11, new ModelResourceLocation("securitycraft:reinforced_stained_glass_blue", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 12, new ModelResourceLocation("securitycraft:reinforced_stained_glass_brown", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 13, new ModelResourceLocation("securitycraft:reinforced_stained_glass_green", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 14, new ModelResourceLocation("securitycraft:reinforced_stained_glass_red", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStainedGlass), 15, new ModelResourceLocation("securitycraft:reinforced_stained_glass_black", "inventory"));
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.keypadChest), 0, new ModelResourceLocation("securitycraft:keypad_chest", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.keypadFurnace), 0, new ModelResourceLocation("securitycraft:keypad_furnace", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.panicButton), 0, new ModelResourceLocation("securitycraft:panic_button", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.securityCamera), 0, new ModelResourceLocation("securitycraft:security_camera", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedDirt), 0, new ModelResourceLocation("securitycraft:reinforced_dirt", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedCobblestone), 0, new ModelResourceLocation("securitycraft:reinforced_cobblestone", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedSandstone), 0, new ModelResourceLocation("securitycraft:reinforced_sandstone_normal", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedSandstone), 1, new ModelResourceLocation("securitycraft:reinforced_sandstone_chiseled", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedSandstone), 2, new ModelResourceLocation("securitycraft:reinforced_sandstone_smooth", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodSlabs), 0, new ModelResourceLocation("securitycraft:reinforced_wood_slabs_oak", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodSlabs), 1, new ModelResourceLocation("securitycraft:reinforced_wood_slabs_spruce", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodSlabs), 2, new ModelResourceLocation("securitycraft:reinforced_wood_slabs_birch", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodSlabs), 3, new ModelResourceLocation("securitycraft:reinforced_wood_slabs_jungle", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodSlabs), 4, new ModelResourceLocation("securitycraft:reinforced_wood_slabs_acacia", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedWoodSlabs), 5, new ModelResourceLocation("securitycraft:reinforced_wood_slabs_darkoak", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsCobblestone), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_cobblestone", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStairsSandstone), 0, new ModelResourceLocation("securitycraft:reinforced_stairs_sandstone", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStoneSlabs), 0, new ModelResourceLocation("securitycraft:reinforced_stone_slabs_stone", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStoneSlabs), 1, new ModelResourceLocation("securitycraft:reinforced_stone_slabs_cobblestone", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.reinforcedStoneSlabs), 2, new ModelResourceLocation("securitycraft:reinforced_stone_slabs_sandstone", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.protecto), 0, new ModelResourceLocation("securitycraft:protecto", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.scannerDoor), 0, new ModelResourceLocation("securitycraft:scanner_door", "inventory"));
		
		//Items
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.codebreaker, 0, new ModelResourceLocation("securitycraft:codebreaker", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.remoteAccessMine, 0, new ModelResourceLocation("securitycraft:remote_access_mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.reinforcedDoorItem, 0, new ModelResourceLocation("securitycraft:door_indestructible_iron_item", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.fWaterBucket, 0, new ModelResourceLocation("securitycraft:bucket_f_water", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.fLavaBucket, 0, new ModelResourceLocation("securitycraft:bucket_f_lava", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.keycardLV1, 0, new ModelResourceLocation("securitycraft:keycard_lv1", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.keycardLV2, 0, new ModelResourceLocation("securitycraft:keycard_lv2", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.keycardLV3, 0, new ModelResourceLocation("securitycraft:keycard_lv3", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.keycardLV4, 0, new ModelResourceLocation("securitycraft:keycard_lv4", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.keycardLV5, 0, new ModelResourceLocation("securitycraft:keycard_lv5", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.limitedUseKeycard, 0, new ModelResourceLocation("securitycraft:limited_use_keycard", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.universalBlockRemover, 0, new ModelResourceLocation("securitycraft:universal_block_remover", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.universalBlockModifier, 0, new ModelResourceLocation("securitycraft:universal_block_modifier", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.whitelistModule, 0, new ModelResourceLocation("securitycraft:whitelist_module", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.blacklistModule, 0, new ModelResourceLocation("securitycraft:blacklist_module", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.redstoneModule, 0, new ModelResourceLocation("securitycraft:redstone_module", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.harmingModule, 0, new ModelResourceLocation("securitycraft:harming_module", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.storageModule, 0, new ModelResourceLocation("securitycraft:storage_module", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.smartModule, 0, new ModelResourceLocation("securitycraft:smart_module", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.disguiseModule, 0, new ModelResourceLocation("securitycraft:disguise_module", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.wireCutters, 0, new ModelResourceLocation("securitycraft:wire_cutters", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.keyPanel, 0, new ModelResourceLocation("securitycraft:keypad_item", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.adminTool, 0, new ModelResourceLocation("securitycraft:admin_tool", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.cameraMonitor, 0, new ModelResourceLocation("securitycraft:camera_monitor", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.scManual, 0, new ModelResourceLocation("securitycraft:sc_manual", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.taser, 0, new ModelResourceLocation("securitycraft:taser", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.universalOwnerChanger, 0, new ModelResourceLocation("securitycraft:universal_owner_changer", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.universalBlockReinforcerLvL1, 0, new ModelResourceLocation("securitycraft:universal_block_reinforcer_lvl1", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.universalBlockReinforcerLvL2, 0, new ModelResourceLocation("securitycraft:universal_block_reinforcer_lvl2", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.universalBlockReinforcerLvL3, 0, new ModelResourceLocation("securitycraft:universal_block_reinforcer_lvl3", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.briefcase, 0, new ModelResourceLocation("securitycraft:briefcase", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.universalKeyChanger, 0, new ModelResourceLocation("securitycraft:universal_key_changer", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mod_SecurityCraft.scannerDoorItem, 0, new ModelResourceLocation("securitycraft:scanner_door_item", "inventory"));
		
		//Mines
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.mine), 0, new ModelResourceLocation("securitycraft:mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.dirtMine), 0, new ModelResourceLocation("securitycraft:dirt_mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.stoneMine), 0, new ModelResourceLocation("securitycraft:stone_mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.cobblestoneMine), 0, new ModelResourceLocation("securitycraft:cobblestone_mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.sandMine), 0, new ModelResourceLocation("securitycraft:sand_mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.diamondOreMine), 0, new ModelResourceLocation("securitycraft:diamond_mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.furnaceMine), 0, new ModelResourceLocation("securitycraft:furnace_mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.trackMine), 0, new ModelResourceLocation("securitycraft:track_mine", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.bouncingBetty), 0, new ModelResourceLocation("securitycraft:bouncing_betty", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.claymore), 0, new ModelResourceLocation("securitycraft:claymore", "inventory"));
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mod_SecurityCraft.ims), 0, new ModelResourceLocation("securitycraft:ims", "inventory"));
	}
}