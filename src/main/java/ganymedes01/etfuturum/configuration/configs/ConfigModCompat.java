package ganymedes01.etfuturum.configuration.configs;

import com.google.common.collect.Lists;
import ganymedes01.etfuturum.configuration.ConfigBase;

import java.io.File;
import java.util.List;

public class ConfigModCompat extends ConfigBase {

	public static int elytraBaublesExpandedCompat;
	public static boolean shulkerBoxesIronChest;

	public static boolean moddedRawOres;
	public static List<String> moddedRawOresBlacklist;
	public static boolean moddedDeepslateOres;
	public static List<String> moddedDeepslateOresBlacklist;

	static final String catMisc = "misc";

	public ConfigModCompat(File file) {
		super(file);

		getCategory(catMisc).setComment("When modded deepslate or raw ore support is enabled, OreDictionary tags will be given to the needed Lord of the Rings ores since they don't have any tags for some reason.\nLoTR Ores that have no raw/deepslate modded alternative will not be tagged.");

		configCats.add(getCategory(catMisc));
	}


	//TODO: Move Iron Chest checks here
	@Override
	protected void syncConfigOptions() {
		shulkerBoxesIronChest = getBoolean("shulkerBoxesIronChest", catMisc, true, "If Iron Chests is installed, allow Iron Shulker boxes to be crafted having all the same tiers as Iron Chests. This option does nothing if Iron Chests is not installed.");
		elytraBaublesExpandedCompat = getInt("elytraBaublesExpandedCompat", catMisc, 1, 0, 2, "Adds compat for Baubles Expanded. Does nothing for standard baubles, this REQUIRES Baubles Expanded! It uses the new \"wings\" slot added by the expanded version. https://modrinth.com/mod/baubles-expanded\nWhen enabled, this allows the player to equip an elytra with a chestplate, by placing the elytra in a \"wings\" slot instead of the chestplate slot. Note that the player can only equip one elytra at a time.\n0 = No compat, do not allow the elytra to be placed in a wings slot.\n1 = Elytra will be placeable in a wings slot. Will enable the slot, if it isn't there.\n2 = The elytra can ONLY go in the wings slots, not the chestplate slot.");

		moddedRawOres = getBoolean("moddedRawOres", catMisc, true, "Raw ores for modded metals. Adds a set of \"general\" raw ores for common metals like \"oreAluminium\", \"oreTin\", etc.");
		moddedRawOresBlacklist = Lists.newArrayList(getStringList("moddedRawOresBlacklist", catMisc, new String[0], "List of modded raw ores to disable. Add a ModID or ore dictionary tag. For example adding \"oreTin\" disables modded raw tin, and adding \"SimpleOres\" would disable raw adamantium ore. CaSe-SeNsItIvE!" +
				"\nEach entry is separated by a new line. This only disables raw ores added from Et Futurum's end and will not affect raw ores from other mods."));
		moddedDeepslateOres = getBoolean("moddedDeepslateOres", catMisc, true, "Deepslate ores for modded ores. Adds a set of \"general\" deepslate ores for common metals like \"oreAluminium\", \"oreTin\", etc, as well as explicit support for numerous mods.");
		moddedDeepslateOresBlacklist = Lists.newArrayList(getStringList("moddedDeepslateOresBlacklist", catMisc, new String[0], "List of modded deepslate ores to disable. Add a ModID or ore dictionary tag. For example adding \"oreTin\" disables deepslate tin, and adding \"SimpleOres\" would disable deepslate adamantium ore. CaSe-SeNsItIvE!" +
				"\nEach entry is separated by a new line. This only disables deepslate ores added from Et Futurum's end and will not affect deepslate ores from other mods."));
		System.out.println();
	}
}
