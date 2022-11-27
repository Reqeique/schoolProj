/** @type {import('tailwindcss').Config} */
module.exports = {
  content: ["./src/**/*.{html,js,jsx}"],
  theme: {
    fontFamily: {
      crimson: "'Crimson Pro', serif;"
    },
    extend: {
      backgroundImage: {
        'image_home': "url('./src/assets/image_home.jpg')"
      }
    },
  },
  plugins: [],
}
