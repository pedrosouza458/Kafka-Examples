from kafka import KafkaProducer
import time
from faker import Faker

bootstrap_servers = ['localhost:9091', 'localhost:9092', 'localhost:9093']
topicName = 'test'

producer = KafkaProducer(bootstrap_servers = bootstrap_servers)
producer = KafkaProducer()
fake = Faker()

for _ in range(100):
    text = fake.text()
    producer.send('text', text.encode('utf-8'))
    print(text)
producer.flush()
time.sleep(20)