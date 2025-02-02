enum Status {
    PLANNING,
    WATCHING,
    COMPLETED,
}

export type Media = {
    id: string;
    title: string;
    source: string;
    sourceId: string;
    description: string;
    poster: string;
    type: string;
    seasons?: Seasons[];
};

export type Seasons = {
    title: string;
    source: string;
    sourceId: string;
    seasonNumber: number;
    episodeCount: number;
    sourceMedia: Media;
};

export type Entry = {
    id: string;
    media: Media;
    status: Status;
    episodeProgress: number;
    seasonProgress: number;
    rating: number;
};

export type Watchlist = {
    planning: Entry[];
    watching: Entry[];
    completed: Entry[];
    all: Entry[];
};
