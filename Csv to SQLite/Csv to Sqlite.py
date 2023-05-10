import sqlite3
import pandas as pd

df = pd.read_csv('Pokemon Database.csv')

df.columns = df.columns.str.strip()

connection = sqlite3.connect('Pokemon.db')

df.to_sql('Pokemon_Number_Types', connection, if_exists='replace')
