package data

object ContentProvider {

    fun provideListOfProjects(): List<Project> = ArrayList<Project>().apply {
        add(
            Project(
                name = "Comera - Video Calls & Chat",
                assetName = "ic_comera.webp",
                description = "Comera is a free-messaging app that allows you to talk to your friends and family via one-to-one chats, voice calls, and video calls through connectivity over mobile data or Wi-Fi. It also enables you to connect through group chats and lets you share photos, videos, documents, locations, and a whole lot more.",
                category = "Communication",
                downloads = "1M+ Downloads"
            )
        )
        add(
            Project(
                name = "Arabits: Learn Arabic Bit By Bit",
                assetName = "ic_arabits.webp",
                description = "Learning Arabic just got easier! Arabits is a complete language learning system created by experienced education professionals & powered by state-of-the-art AI.",
                category = "Education",
                downloads = "1M+ Downloads"
            )
        )

        add(
            Project(
                name = "Airlift Express",
                assetName = "ic_airlift.webp",
                description = "Airlift makes life easier!\nNow you can shop everything in one place, and enjoy a quick 30-minute delivery right at your doorstep!",
                category = "Shopping",
                downloads = "1M+ Downloads"
            )
        )

        add(
            Project(
                name = "Mischief Maker",
                assetName = "ic_mm.webp",
                description = "Purpose of this application is to validate the user’s information and location by a unique QR code which allows the Mischief Maker (admin) to track an actual presence of the user in an event. ",
                category = "Events",
                downloads = "1K+ Downloads"
            )
        )
        add(
            Project(
                name = "GymHub",
                assetName = "ic_gh.webp",
                description = "Explore the world of fitness at your fingertips.\nGymhub is the only gym-finder app in the world which is designed for everyone. Our goal is to do the work for you so you can do the workout. GymHub brings complete convenience to your fitness by streamlining the entire gym membership process.",
                category = "Health & Fitness",
                downloads = "1K+ Downloads"
            )
        )
    }

    fun provideListOfWorkExperience(): List<WorkExperience>  = ArrayList<WorkExperience>().apply {
        add(
            WorkExperience(
                "Software Engineer - I",
                "Avrioc Technologies",
                "ic_avrioc.jpeg",
                "March 2023",
                "Present",
                "Abu Dhabi, United Arab Emirates",
                ""
            )
        )

        add(
            WorkExperience(
                "Software Engineer - II",
                "Alef Education",
                "ic_alef.jpeg",
                "May 2021",
                "Dec 2022",
                "Remote",
                "Integrated a complete monetization module in the app to access premium content.\n" +
                        "Helped in improving application performance by fixing ANRs and Memory leaks.\n" +
                        "Integrated In-App updates.\n" +
                        "Helped in improving the overall architecture of the app."
            )
        )

        add(
            WorkExperience(
                "Software Engineer - II",
                "Airlift Technologies",
                "ic_airlift.webp",
                "March 2022",
                "June 2022",
                "Remote",
                "Worked on multiple CX-App features.\n" +
                        "Identifying and fixing tech-debt.\n" +
                        "Write clean and testable code."
            )
        )

        add(
            WorkExperience(
                "Software Engineer - II",
                "PNC Solutions",
                "ic_pnc.jpeg",
                "May 2017",
                "Dec 2021",
                "Karachi, Pakistan",
                "Managed a team of 5 Android Developers from a technical perspective.\n" +
                        "Helped to design a base architecture ensuring scalability, maintainability and readability of a project.\n" +
                        "Started and finished various Android Projects from the scratch."
            )
        )
    }
}