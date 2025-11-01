package dev.hangarmc.hangar.util;

public final class TransactionUtil {

    public static void withTransaction(String op, String name, Runnable runnable) {
        // TODO sentry
//        TransactionOptions transactionOptions = new TransactionOptions();
//        transactionOptions.setBindToScope(true);
//        ITransaction transaction = Sentry.startTransaction(name, op, transactionOptions);
        try {
            runnable.run();
        } catch (Exception e) {
//            transaction.setThrowable(e);
//            transaction.setStatus(SpanStatus.INTERNAL_ERROR);
            throw e;
        } finally {
//            transaction.finish();
        }
    }
}
