import sqlite3
import pandas as pd

df = pd.read_csv('Pokemon_Types.csv')

df.columns = df.columns.str.strip()

connection = sqlite3.connect('Pokemon.db')

df.to_sql('Pokemon_Types', connection, if_exists='replace')
