################################################################################
#     ____                          __     _                          ___
#    / __ \  __  __  ___    _____  / /_   (_)  ____    ____          <  /
#   / / / / / / / / / _ \  / ___/ / __/  / /  / __ \  / __ \         / / 
#  / /_/ / / /_/ / /  __/ (__  ) / /_   / /  / /_/ / / / / /        / /  
#  \___\_\ \__,_/  \___/ /____/  \__/  /_/   \____/ /_/ /_/        /_/   
#                                                                        
#  Question 1
################################################################################
#
# Instructions:
# The two functions below are used to tell the weather. They have some bugs that
# need to be fixed. The test suite in `question1_test.py` will verify the output.
# Read the test suite to know the values that these functions should return.

def get_city_temperature(city):
   city_temperature = {
    "New York": 14,
    "Quito": 22,
    "Sao Paulo": 17,
    "San Francisco": 16
   }
   return city_temperature.get(city, "City not found")

def get_city_weather(city):

  sky_condition = None

  city_sky_condition = {
    "New York": "rainy",
    "Quito": "sunny",
    "Sao Paulo": "cloudy",
    "San Francisco": "sunny"
   }
  
  sky_condition = city_sky_condition.get(city, "City not found")

  temperature = get_city_temperature(city)

  return str(temperature) + " degrees and " + sky_condition