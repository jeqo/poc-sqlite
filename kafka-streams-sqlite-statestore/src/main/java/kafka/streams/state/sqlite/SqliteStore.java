package kafka.streams.state.sqlite;

import org.apache.kafka.streams.processor.ProcessorContext;
import org.apache.kafka.streams.processor.StateStore;
import org.apache.kafka.streams.processor.StateStoreContext;

public class SqliteStore implements StateStore {

    final String name;

    public SqliteStore(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return this.name;
    }

    @Override
    public void init(ProcessorContext processorContext, StateStore stateStore) {

    }

    @Override
    public void init(StateStoreContext context, StateStore root) {
        StateStore.super.init(context, root);
    }

    @Override
    public void flush() {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean persistent() {
        return false;
    }

    @Override
    public boolean isOpen() {
        return false;
    }
}
