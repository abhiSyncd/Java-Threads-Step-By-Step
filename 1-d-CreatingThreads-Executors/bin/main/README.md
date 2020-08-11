        Using Lamdba

        
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            //Runnable Task
        });

        executor.shutdown();


        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<String> future = executor.submit(() -> {
            //Callable Task
        });
