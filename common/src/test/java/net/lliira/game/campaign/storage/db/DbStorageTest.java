package net.lliira.game.campaign.storage.db;

import org.junit.Test;
import static org.junit.Assert.*;

public class DbStorageTest {
    private final DbStorage storage = DbStorage.DB_STORAGE;

    @Test
    public void getUserFactory() {
        assertNotNull(storage.getUserFactory());
    }
}
