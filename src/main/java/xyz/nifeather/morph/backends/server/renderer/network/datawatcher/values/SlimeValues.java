package xyz.nifeather.morph.backends.server.renderer.network.datawatcher.values;

import com.github.retrooper.packetevents.protocol.entity.data.EntityDataTypes;
import xyz.nifeather.morph.backends.server.renderer.network.datawatcher.values.basetypes.AgeableMobValues;

/**
 * Since 26.2, {@code Slime} and {@code MagmaCube} extend {@code AbstractCubeMob}, which extends {@code AgeableMob}. <br>
 * So the size value moved behind {@link AgeableMobValues#IS_BABY} and {@link AgeableMobValues#AGE_LOCKED}.
 */
public class SlimeValues extends AgeableMobValues
{
    public final SingleValue<Integer> SIZE = createSingle("slimemagma_size", 1, EntityDataTypes.INT);

    public SlimeValues()
    {
        super();

        registerSingle(SIZE);
    }
}
