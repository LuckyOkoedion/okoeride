#!/bin/bash

cqlsh -u cassandra -p cassandra -e "CREATE KEYSPACE IF NOT EXISTS the_ride WITH replication = {'class' : 'SimpleStrategy', 'replication_factor' : 1}"
