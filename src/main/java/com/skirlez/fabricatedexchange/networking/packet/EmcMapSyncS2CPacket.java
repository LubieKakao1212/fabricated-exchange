package com.skirlez.fabricatedexchange.networking.packet;

import com.skirlez.fabricatedexchange.emc.EmcData;
import com.skirlez.fabricatedexchange.util.SuperNumber;

import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.PacketByteBuf;

public class EmcMapSyncS2CPacket {
    /*
     * 
*             PacketByteBuf buffer = PacketByteBufs.create();
            int iterations = EmcData.emcMap.keySet().size();
            buffer.writeInt(iterations);
            Iterator<String> iterator = EmcData.emcMap.keySet().iterator();
            for (int i = 0; i < iterations; i++) {
                String s = (String)iterator.next();
                buffer.writeString(s);
                buffer.writeString(EmcData.emcMap.get(s).divisionString());
            }
            ServerPlayNetworking.send(handler.player, ModMessages.EMC_MAP_SYNC_IDENTIFIER, buffer);
        });
     */
    public static void receive(MinecraftClient client, ClientPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        EmcData.emcMap.clear();
        int iterations = buf.readInt();
        for (int i = 0; i < iterations; i++) {
            String s = buf.readString();
            EmcData.emcMap.put(s, new SuperNumber(buf.readString()));
        }
        
    }
}



