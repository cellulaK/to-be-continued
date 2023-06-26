```text
MVCC: multi-version concurrent control(多版本并发控制)

MVCC在MySQL InnoDB 中的实现主要是为了提高数据库的并发能力，用更好的方式去处理读-写冲突，做到即使有读写冲突，也能做到不加锁，非阻塞并发读。

当前读：
    像 select lock in share mode(共享锁)， select for update、update、insert、delete(排他锁)，这些操作都是一种当前读，为什么叫当前读？
就是读取的记录的最新版本，读取时还要保证其他事务不能修改当前记录，会对读取的记录进行加锁

快照读：
    像不加锁的select操作就是快照读，即不加锁的非阻塞读；快照读的前提是隔离级别不是串行级别(serializable)，串行级别下的快照读会退化为当前读，
之所以出现快照读的情况，是基于提高并发性能的考虑，快照读的实现是基于多版本并发控制，即MVCC，可以认为MVCC是行锁的一个变种，但它在很多情况下，避免了
加锁，降低了开销；既然是基于多版本，即快照读可能读到的不一定是数据的最新版本，而有可能是之前的历史版本


说白了MVCC就是为了实现读-写冲突不加锁，而这个读指的是快照读，而非当前读，当前读实际上是一种加锁的操作，是悲观锁的实现



```