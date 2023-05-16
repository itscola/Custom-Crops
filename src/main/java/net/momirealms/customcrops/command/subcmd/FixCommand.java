/*
 *  Copyright (C) <2022> <XiaoMoMi>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package net.momirealms.customcrops.command.subcmd;

import net.momirealms.customcrops.CustomCrops;
import net.momirealms.customcrops.api.object.basic.MessageManager;
import net.momirealms.customcrops.api.util.AdventureUtils;
import net.momirealms.customcrops.command.AbstractSubCommand;
import org.bukkit.command.CommandSender;

import java.util.List;

public class FixCommand extends AbstractSubCommand {

    public static final FixCommand INSTANCE = new FixCommand();

    public FixCommand() {
        super("fixcorrupted");
    }

    @Override
    public boolean onCommand(CommandSender sender, List<String> args) {
        if (lackArgs(sender, 1, args.size())) return true;

        String world = args.get(0);
        CustomCrops.getInstance().getWorldDataManager().fixCorruptedData(world);
        AdventureUtils.sendMessage(sender, MessageManager.prefix + "Fixing would be ongoing in next 30s");
        return true;
    }
}