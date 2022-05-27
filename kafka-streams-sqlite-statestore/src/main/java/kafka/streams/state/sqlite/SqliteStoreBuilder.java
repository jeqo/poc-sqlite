package kafka.streams.state.sqlite;

import org.apache.kafka.streams.state.StoreBuilder;

import java.util.Map;

public class SqliteStoreBuilder implements StoreBuilder<SqliteStore> {
    @Override
    public StoreBuilder<SqliteStore> withCachingEnabled() {
        return null;
    }

    @Override
    public StoreBuilder<SqliteStore> withCachingDisabled() {
        return null;
    }

    @Override
    public StoreBuilder<SqliteStore> withLoggingEnabled(Map<String, String> map) {
        return null;
    }

    @Override
    public StoreBuilder<SqliteStore> withLoggingDisabled() {
        return null;
    }

    @Override
    public SqliteStore build() {
        return null;
    }

    @Override
    public Map<String, String> logConfig() {
        return null;
    }

    @Override
    public boolean loggingEnabled() {
        return false;
    }

    @Override
    public String name() {
        return null;
    }
}
