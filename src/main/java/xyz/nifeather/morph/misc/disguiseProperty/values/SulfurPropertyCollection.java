package xyz.nifeather.morph.misc.disguiseProperty.values;

import org.bukkit.entity.Slime;
import org.jetbrains.annotations.NotNull;
import xyz.nifeather.morph.misc.disguiseProperty.*;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class SulfurPropertyCollection extends SlimeMagmaPropertyCollection
{
    public final SingleProperty<Integer> SIZE = SingleProperty.builder(PropertyNames.SULFUR_SIZE, 1)
            .withInputHandle(this::readSize)
            .withOutputHandle(OutputHandles::writeInteger)
            .build();

    private Optional<Integer> readSize(String propertyName, String string) throws ParseErrorException
    {
        // localizable message not required, since readInteger always return a value or throw ParseErrorException
        var val = InputHandles.readInteger(propertyName, string)
                .orElseThrow(() -> new ParseErrorException(propertyName, "readSize: Unable to parse sulfur size"));

        InputHandles.throwIfOutOfBounds(propertyName, val, 1, 2);

        return Optional.of(val);
    }

    public SulfurPropertyCollection()
    {
        registerSingle(SIZE);
    }

    @Override
    protected void setupPropertiesFromEntity(PropertyHandler propertyHandler, @NotNull Slime targetEntity)
    {
        super.setupPropertiesFromEntity(propertyHandler, targetEntity);

        propertyHandler.set(SIZE, targetEntity.getSize());
    }

    @Override
    protected void setupDefaultProperties(PropertyHandler propertyHandler)
    {
        propertyHandler.set(SIZE, ThreadLocalRandom.current().nextInt(1, 3));
    }
}
