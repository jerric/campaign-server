package net.lliira.game.campaign.storage.db;

import static org.junit.Assert.*;

import org.junit.Test;

public class DbStorageTest extends DbTestBase {


    @Test
    public void getUserFactory() {
        assertNotNull(DbStorage.DB_STORAGE.getUserFactory());
    }
}
