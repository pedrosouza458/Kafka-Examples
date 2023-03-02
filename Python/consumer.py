from kafka import KafkaConsumer
consumer = KafkaConsumer('text', bootstrap_servers=['localhost:9091','localhost:9092','localhost:9093'])

for message in consumer:
    print (message)